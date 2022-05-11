package nz.co.kiwibank.architecturedemo.ui.meh.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import nz.co.kiwibank.architecturedemo.MainNavDirections
import nz.co.kiwibank.architecturedemo.ui.base.BaseViewModel
import nz.co.kiwibank.architecturedemo.ui.meh.model.MehModel
import nz.co.kiwibank.networklibrary.ApiConnection
import nz.co.kiwibank.networklibrary.ApiConnectionImpl

class MehViewModel(application: Application) : BaseViewModel(application) {

    private val _userModel = MutableLiveData<MehModel>()
    val userModel get() = _userModel

    init {
        _userModel.value = MehModel("", "")
    }

    fun loginClicked() {
        // Do validation
        ApiConnectionImpl.login(userModel.value?.username ?: "", userModel.value?.password ?: "").subscribeBy(
            onNext = { response ->
                if (response.isSuccess) {
                    when (response.error?.code) {
                        "69" -> showMessage(response.error?.message)
                        "96" -> showMessage(response.error?.message)
                        else -> navigate(MainNavDirections.actionGlobalAuthenticatedFragment(userModel.value?.username ?: "", userModel.value?.password ?: ""))
                    }
                } else {
                    showMessage(response.error?.message)
                }
            },
            onError = {
                showMessage("Oops...  Something went wrong")
            }
        )
    }

    private fun showMessage(message: String?) {
        Toast.makeText(getApplication(), message ?: "No message returned", Toast.LENGTH_LONG).show()
    }

    fun updateUserName(userName: String) {
        _userModel.value?.username = userName
    }

    fun updatePassword(password: String) {
        _userModel.value?.password = password
    }
}
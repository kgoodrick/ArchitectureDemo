package nz.co.kiwibank.architecturedemo.ui.authentication.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.kotlin.subscribeBy
import nz.co.kiwibank.architecturedemo.MainNavDirections
import nz.co.kiwibank.architecturedemo.ui.base.BaseViewModel
import nz.co.kiwibank.architecturedemo.ui.authentication.model.AuthenticationModel
import nz.co.kiwibank.networklibrary.DemoApiConnection

class AuthenticationViewModel(application: Application) : BaseViewModel(application) {

    private val _userModel = MutableLiveData<AuthenticationModel>()
    val userModel get() = _userModel

    init {
        _userModel.value = AuthenticationModel("", "")
    }

    fun loginClicked() {
        // Do some validation here.
        DemoApiConnection.authApi.login(userModel.value?.username ?: "", userModel.value?.password ?: "").subscribeBy(
            onSuccess = { response ->
                if (response.isSuccess) {
                    if (response.error != null) {
                        showMessage(response.error?.message)
                    } else {
                        navigate(MainNavDirections.actionGlobalAuthenticatedFragment(userModel.value?.username ?: "", userModel.value?.password ?: ""))
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
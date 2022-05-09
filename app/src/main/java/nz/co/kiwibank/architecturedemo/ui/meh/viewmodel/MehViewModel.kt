package nz.co.kiwibank.architecturedemo.ui.meh.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nz.co.kiwibank.architecturedemo.MainNavDirections
import nz.co.kiwibank.architecturedemo.ui.base.BaseViewModel
import nz.co.kiwibank.architecturedemo.ui.meh.model.MehModel

class MehViewModel : BaseViewModel() {

    private val _userModel = MutableLiveData<MehModel>()
    val userModel get() = _userModel

    init {
        _userModel.value = MehModel("", "")
    }

    fun loginClicked() {
        // Do validation
        navigate(MainNavDirections.actionGlobalAuthenticatedFragment(userModel.value?.username ?: "", userModel.value?.password ?: ""))
    }

    fun updateUserName(userName: String) {
        _userModel.value?.username = userName
    }

    fun updatePassword(password: String) {
        _userModel.value?.password = password
    }
}
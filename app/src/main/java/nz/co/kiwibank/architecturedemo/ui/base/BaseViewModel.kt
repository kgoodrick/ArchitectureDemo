package nz.co.kiwibank.architecturedemo.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import nz.co.kiwibank.architecturedemo.ui.base.util.Event
import nz.co.kiwibank.architecturedemo.ui.base.util.NavigationCommand

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = Event(NavigationCommand.Back)
    }

}
package nz.co.kiwibank.architecturedemo.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import nz.co.kiwibank.corelibrary.extensions.observeNonNull
import nz.co.kiwibank.architecturedemo.ui.base.util.NavigationCommand

abstract class BaseFragment<BINDING: ViewBinding, VM: BaseViewModel>(): Fragment() {

    protected abstract val viewModel: VM

    protected abstract val binding: BINDING

    protected abstract fun onReady(savedInstanceState: Bundle?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()

        onReady(savedInstanceState)
    }

    private fun observeNavigation() {
        viewModel.navigation.observeNonNull(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection -> findNavController().navigate(navCommand.directions)
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }
}
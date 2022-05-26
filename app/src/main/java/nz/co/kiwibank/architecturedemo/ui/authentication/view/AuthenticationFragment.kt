package nz.co.kiwibank.architecturedemo.ui.authentication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import nz.co.kiwibank.architecturedemo.databinding.FragmentAthenticationBinding
import nz.co.kiwibank.architecturedemo.ui.base.BaseFragment
import nz.co.kiwibank.architecturedemo.ui.authentication.viewmodel.AuthenticationViewModel

class AuthenticationFragment : BaseFragment<FragmentAthenticationBinding, AuthenticationViewModel>() {

    override val viewModel: AuthenticationViewModel by viewModels()
    override lateinit var binding: FragmentAthenticationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAthenticationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usernameTextInput.editText?.addTextChangedListener(
            onTextChanged = { userName, _ ,_, _ ->
                viewModel.updateUserName(userName.toString())
            }
        )
        binding.PasswordTextInput.editText?.addTextChangedListener(
            onTextChanged = { password, _, _, _ ->
                viewModel.updatePassword(password.toString())
            }
        )
        binding.button.setOnClickListener {
            viewModel.loginClicked()
        }
    }

    override fun onReady(savedInstanceState: Bundle?) {

    }

}
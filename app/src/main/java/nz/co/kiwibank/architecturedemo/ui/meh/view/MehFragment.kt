package nz.co.kiwibank.architecturedemo.ui.meh.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import nz.co.kiwibank.architecturedemo.databinding.MehFragmentBinding
import nz.co.kiwibank.architecturedemo.ui.base.BaseFragment
import nz.co.kiwibank.architecturedemo.ui.meh.viewmodel.MehViewModel

class MehFragment : BaseFragment<MehFragmentBinding, MehViewModel>() {

    override val viewModel: MehViewModel by viewModels()
    override lateinit var binding: MehFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MehFragmentBinding.inflate(inflater)
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
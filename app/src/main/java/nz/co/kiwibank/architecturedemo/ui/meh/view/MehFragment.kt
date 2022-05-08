package nz.co.kiwibank.architecturedemo.ui.meh.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import nz.co.kiwibank.architecturedemo.databinding.MehFragmentBinding
import nz.co.kiwibank.architecturedemo.ui.meh.viewmodel.MehViewModel

class MehFragment : Fragment() {

    private val viewModel: MehViewModel by viewModels()
    private lateinit var binding:MehFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MehFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            viewModel.loginClicked()
        }
    }

}
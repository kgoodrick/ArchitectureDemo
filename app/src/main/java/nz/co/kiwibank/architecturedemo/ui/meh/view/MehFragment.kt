package nz.co.kiwibank.architecturedemo.ui.meh.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nz.co.kiwibank.architecturedemo.databinding.MehFragmentBinding
import nz.co.kiwibank.architecturedemo.ui.meh.viewmodel.MehViewModel

class MehFragment : Fragment() {

    companion object {
        fun newInstance() = MehFragment()
    }

    private lateinit var viewModel: MehViewModel
    private lateinit var binding : MehFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MehFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MehViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
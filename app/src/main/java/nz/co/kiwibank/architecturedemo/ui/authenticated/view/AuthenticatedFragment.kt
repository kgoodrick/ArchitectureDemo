package nz.co.kiwibank.architecturedemo.ui.authenticated.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nz.co.kiwibank.architecturedemo.databinding.FragmentAuthenticatedBinding

class AuthenticatedFragment : Fragment() {

    private lateinit var binding:FragmentAuthenticatedBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAuthenticatedBinding.inflate(inflater)
        return binding.root
    }
}
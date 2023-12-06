package uz.crud.foodexpressapplication.screens.auth.registarationScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.apply {
            btnRegistration.setOnClickListener { findNavController().navigate(R.id.action_registrationFragment_to_mainFragment2) }
        }

        return binding.root
    }
}
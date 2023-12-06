package uz.crud.foodexpressapplication.screens.auth.loginScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.FragmentSignBinding

class SignFragment : Fragment() {

    private val binding by lazy { FragmentSignBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.apply {
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_signFragment_to_registrationFragment)
            }

            tvRegistration.setOnClickListener {
                findNavController().navigate(R.id.registrationFragment)
            }
        }

        return binding.root
    }

}
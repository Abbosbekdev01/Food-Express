package uz.crud.foodexpressapplication.screens.splashScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.FragmentSplashBinding
import uz.crud.foodexpressapplication.utils.Constants

class SplashFragment : Fragment() {

    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.splashImg.postDelayed({
            if (Hawk.get(Constants.PREF_TOKEN, "").isEmpty()) {
                findNavController().navigate(R.id.action_splashFragment_to_signFragment)
            } else {
                findNavController().navigate(R.id.mainFragment3)
            }
        }, 1500)

        return binding.root
    }
}
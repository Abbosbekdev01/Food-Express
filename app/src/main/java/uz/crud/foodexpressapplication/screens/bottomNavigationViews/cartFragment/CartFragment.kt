package uz.crud.foodexpressapplication.screens.bottomNavigationViews.cartFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.crud.foodexpressapplication.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private val binding by lazy { FragmentCartBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }
}
package uz.crud.foodexpressapplication.screens.restaurant.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.crud.foodexpressapplication.adapters.CategoryTabAdapter
import uz.crud.foodexpressapplication.adapters.CategoryTanAdapterCallback
import uz.crud.foodexpressapplication.adapters.ProductAdapter
import uz.crud.foodexpressapplication.databinding.FragmentRestaurantDetailBinding
import uz.crud.foodexpressapplication.models.CategoryModel
import uz.crud.foodexpressapplication.models.ProductModel
import uz.crud.foodexpressapplication.screens.restaurant.feedback.FeedbackFragment

class RestaurantDetailFragment : Fragment(), CategoryTanAdapterCallback {

    private val binding by lazy { FragmentRestaurantDetailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerCategories.adapter = CategoryTabAdapter(
                listOf(
                    CategoryModel("Fast food", ""),
                    CategoryModel("Turkish", ""),
                    CategoryModel("Uzb food", ""),
                    CategoryModel("Meat", ""),
                ), this@RestaurantDetailFragment
            )
        }

        binding.apply {
            recyclerProducts.adapter = ProductAdapter(
                listOf(
                    ProductModel("", ""),
                    ProductModel("", ""),
                    ProductModel("", ""),
                    ProductModel("", ""),
                    ProductModel("", ""),
                    ProductModel("", ""),
                )
            )
        }

        binding.btnFeedback.setOnClickListener {
            val fragment = FeedbackFragment.newInstance()
        }
    }

    override fun onClick(item: CategoryModel) {

    }
}
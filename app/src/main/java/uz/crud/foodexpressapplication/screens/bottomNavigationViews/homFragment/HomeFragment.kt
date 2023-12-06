package uz.crud.foodexpressapplication.screens.bottomNavigationViews.homFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.adapters.CategoryAdapter
import uz.crud.foodexpressapplication.adapters.RestaurantAdapter
import uz.crud.foodexpressapplication.adapters.RestaurantCallback
import uz.crud.foodexpressapplication.adapters.SlideAdapter
import uz.crud.foodexpressapplication.databinding.FragmentHomeBinding
import uz.crud.foodexpressapplication.models.CategoryModel
import uz.crud.foodexpressapplication.models.RestaurantModel
import uz.crud.foodexpressapplication.models.SlideModel

class HomeFragment : Fragment(), RestaurantCallback {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerSlides.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            recyclerSlides.adapter = SlideAdapter(
                listOf(
                    SlideModel("", "", ""),
                    SlideModel("", "", ""),
                    SlideModel("", "", ""),
                    SlideModel("", "", ""),
                    SlideModel("", "", "")
                )
            )
        }

        binding.apply {
            recyclerCategory.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

            recyclerCategory.adapter = CategoryAdapter(
                listOf(
                    CategoryModel("", ""),
                    CategoryModel("", ""),
                    CategoryModel("", ""),
                    CategoryModel("", ""),
                    CategoryModel("", "")
                )
            )
        }

        binding.apply {
            recyclerNearbyRestaurants.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerNearbyRestaurants.adapter = RestaurantAdapter(
                listOf(
                    RestaurantModel("", "", ""),
                    RestaurantModel("", "", ""),
                    RestaurantModel("", "", ""),
                    RestaurantModel("", "", ""),
                    RestaurantModel("", "", ""),
                ), this@HomeFragment
            )
        }
    }

    override fun onClick(item: RestaurantModel, position: Int) {
        findNavController().navigate(R.id.action_homeFragment2_to_restaurantDetailFragment)
    }
}
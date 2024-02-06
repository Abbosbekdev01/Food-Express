package uz.crud.foodexpressapplication.screens.bottomNavigationViews.homFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.adapters.CategoryAdapter
import uz.crud.foodexpressapplication.adapters.RestaurantAdapter
import uz.crud.foodexpressapplication.adapters.RestaurantCallback
import uz.crud.foodexpressapplication.adapters.SlideAdapter
import uz.crud.foodexpressapplication.databinding.FragmentHomeBinding
import uz.crud.foodexpressapplication.models.CategoryModel
import uz.crud.foodexpressapplication.models.request.restaurantFilter.RestaurantFilterRequest
import uz.crud.foodexpressapplication.models.response.BaseResponse
import uz.crud.foodexpressapplication.models.response.offerModel.OfferModel
import uz.crud.foodexpressapplication.models.response.restaurantFilter.RestaurantFilterResponse
import uz.crud.foodexpressapplication.retrofit.ApiService
import uz.crud.foodexpressapplication.utils.Constants
import uz.crud.foodexpressapplication.utils.showMessage

class HomeFragment : Fragment(), RestaurantCallback {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    lateinit var api: ApiService
    var compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)

        binding.apply {
            recyclerSlides.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.apply {
            recyclerCategory.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.apply {
            recyclerNearbyRestaurants.layoutManager = GridLayoutManager(requireContext(), 2)
        }
        loadData()
    }

    fun loadData() {
        compositeDisposable.add(
            api.getOffers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<OfferModel>?>>() {
                    override fun onNext(t: BaseResponse<List<OfferModel>?>) {
                        binding.recyclerSlides.adapter = SlideAdapter(t.data ?: emptyList())
                    }

                    override fun onError(e: Throwable) {
                        this@HomeFragment.requireActivity().showMessage(e.localizedMessage)
                    }

                    override fun onComplete() {

                    }
                })
        )
        compositeDisposable.add(
            api.getCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<CategoryModel>?>>() {
                    override fun onNext(t: BaseResponse<List<CategoryModel>?>) {
                        binding.recyclerCategory.adapter = CategoryAdapter(t.data ?: emptyList())
                    }

                    override fun onError(e: Throwable) {
                        this@HomeFragment.requireActivity().showMessage(e.localizedMessage)
                    }

                    override fun onComplete() {

                    }
                })
        )
        compositeDisposable.add(
            api.postRestaurant(RestaurantFilterRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponse<List<RestaurantFilterResponse>>>() {
                    override fun onNext(t: BaseResponse<List<RestaurantFilterResponse>>) {
                        binding.recyclerNearbyRestaurants.adapter = RestaurantAdapter(t.data, this@HomeFragment)
                    }

                    override fun onError(e: Throwable) {
                        this@HomeFragment.requireActivity().showMessage(e.localizedMessage)
                    }

                    override fun onComplete() {

                    }
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()

    }

    override fun onClick(item: RestaurantFilterResponse, position: Int) {
        findNavController().navigate(R.id.action_homeFragment2_to_restaurantDetailFragment)
    }
}
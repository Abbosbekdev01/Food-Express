package uz.crud.foodexpressapplication.retrofit

import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import uz.crud.foodexpressapplication.models.CategoryModel
import uz.crud.foodexpressapplication.models.request.LoginRequest
import uz.crud.foodexpressapplication.models.request.RegisterRequest
import uz.crud.foodexpressapplication.models.request.restaurantFilter.RestaurantFilterRequest
import uz.crud.foodexpressapplication.models.response.BaseResponse
import uz.crud.foodexpressapplication.models.response.login.LoginResponse
import uz.crud.foodexpressapplication.models.response.offerModel.OfferModel
import uz.crud.foodexpressapplication.models.response.register.RegisterResponse
import uz.crud.foodexpressapplication.models.response.restaurantFilter.RestaurantFilterResponse
import uz.crud.foodexpressapplication.utils.Constants

interface ApiService {

    @POST(Constants.login)
    // header key ni berishni 1-usuli
//    @Headers("Key: xUA8m4ARCoeYGBYCmKvEcJJ4CsiONc")
    fun login(
        @Body request: LoginRequest,
        @Header("Key") key: String = Constants.DEVELOPER_KEY
    ): Call<BaseResponse<LoginResponse?>>

    @POST(Constants.register)
    fun registration(
        @Body request: RegisterRequest,
        @Header("Key") key: String = Constants.DEVELOPER_KEY
    ): Call<BaseResponse<RegisterResponse>>

    @GET(Constants.getOffers)
    fun getOffers(
        @Header("Key") key: String = Constants.DEVELOPER_KEY
    ): Observable<BaseResponse<List<OfferModel>?>>

    @GET(Constants.getCategory)
    fun getCategory(
        @Header("Key") key: String = Constants.DEVELOPER_KEY
    ): Observable<BaseResponse<List<CategoryModel>?>>

    @POST(Constants.postRestaurant)
    fun postRestaurant(
        @Body restaurantFilter: RestaurantFilterRequest,
        @Header("Key") key: String = Constants.DEVELOPER_KEY
    ): Observable<BaseResponse<List<RestaurantFilterResponse>>>
}
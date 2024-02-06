//package uz.crud.foodexpressapplication.retrofit
//
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//import uz.crud.foodexpressapplication.utils.Constants
//
//object ApiClient {
//
//    val api: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
//
//    private val retrofit by lazy {
////        val client = OkHttpClient.Builder().apply {
////            addInterceptor(TokenInterceptor())
////        }.build()
//
//        Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
////            .client(client)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}
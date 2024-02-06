package uz.crud.foodexpressapplication.screens.auth.loginScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.orhanobut.hawk.Hawk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.FragmentSignBinding
import uz.crud.foodexpressapplication.models.request.LoginRequest
import uz.crud.foodexpressapplication.models.response.BaseResponse
import uz.crud.foodexpressapplication.models.response.login.LoginResponse
import uz.crud.foodexpressapplication.retrofit.ApiService
import uz.crud.foodexpressapplication.utils.Constants

private const val TAG = "SignFragment"

class SignFragment : Fragment() {
    private val binding by lazy { FragmentSignBinding.inflate(layoutInflater) }
    private lateinit var api: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        api = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        binding.apply {

            btnLogin.setOnClickListener {
                flProgress.visibility = View.VISIBLE
                val phone = edtPhone.text.toString()
                val passwod = edtPassword.text.toString()
                api.login(
                    LoginRequest(phone = phone, password = passwod)
                ).enqueue(object : Callback<BaseResponse<LoginResponse?>> {
                    override fun onResponse(
                        call: Call<BaseResponse<LoginResponse?>>,
                        response: Response<BaseResponse<LoginResponse?>>
                    ) {
                        flProgress.visibility = View.GONE
                        if (response.isSuccessful) {
                            if (response.body()!!.success) {
                                Hawk.put(Constants.PREF_TOKEN, response.body()!!.data!!.token)
                                Log.d(TAG, "onResponse: ${response.body()?.data?.token}")

                                findNavController().navigate(R.id.mainFragment3)
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "${response.body()?.message}", Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "${response.errorBody()}", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse<LoginResponse?>>, t: Throwable) {
                        flProgress.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            "${t.localizedMessage}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })
            }

            tvRegistration.setOnClickListener {
                findNavController().navigate(R.id.registrationFragment)
            }
        }
    }

}
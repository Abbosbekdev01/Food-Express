package uz.crud.foodexpressapplication.models.response.login

data class LoginResponse(
    val id: Int,
    val fullname: String,
    val phone: String,
    val avatar: Any,
    val status: String,
    val token: String
)
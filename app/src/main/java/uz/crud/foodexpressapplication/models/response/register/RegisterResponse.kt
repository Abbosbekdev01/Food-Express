package uz.crud.foodexpressapplication.models.response.register

data class RegisterResponse(
    val avatar: Any,
    val fullname: String,
    val id: Int,
    val phone: String,
    val status: String,
    val token: String
)
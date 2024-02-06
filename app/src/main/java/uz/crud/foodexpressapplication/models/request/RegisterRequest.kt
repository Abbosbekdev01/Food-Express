package uz.crud.foodexpressapplication.models.request

data class RegisterRequest(
    val fullname: String,
    val password: String,
    val phone: String
)
package uz.crud.foodexpressapplication.models.request

data class LoginRequest(
    val phone: String,
    val password: String
)
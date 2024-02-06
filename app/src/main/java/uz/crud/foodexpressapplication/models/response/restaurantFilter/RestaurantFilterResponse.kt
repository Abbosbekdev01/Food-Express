package uz.crud.foodexpressapplication.models.response.restaurantFilter

data class RestaurantFilterResponse(
    val id: Int,
    val address: String,
    val name: String,
    val distance: Double,
    val main_image: String,
    val rating: Double,
)
package uz.crud.foodexpressapplication.models.request.restaurantFilter

data class RestaurantFilterRequest(
    val category_id: Int = 0,
    val district_id: Int = 0,
    val food_id: Int = 0,
    val keyword: String = "",
    val latitude: Double = 0.0,
    val limit: Int = 0,
    val longitude: Double = 0.0,
    val region_id: Int = 0,
    val sort: String = "distance"
)
package uz.crud.foodexpressapplication.models

data class CategoryModel(
    val name: String,
    val image: String,
    var active: Boolean = false
)

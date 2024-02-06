package uz.crud.foodexpressapplication.models

data class CategoryModel(
    val id: Int,
    val title: String,
    val image: String,
    var active: Boolean = false
    //
)

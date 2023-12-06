package uz.crud.foodexpressapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.crud.foodexpressapplication.databinding.RestaurantItemLayoutBinding
import uz.crud.foodexpressapplication.models.CategoryModel
import uz.crud.foodexpressapplication.models.RestaurantModel

interface RestaurantCallback {
    fun onClick(item: RestaurantModel, position: Int)
}

class RestaurantAdapter(val items: List<RestaurantModel>, val callback: RestaurantCallback) :
    RecyclerView.Adapter<RestaurantAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: RestaurantItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            RestaurantItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        holder.itemView.setOnClickListener {
            callback.onClick(item, position)
        }
    }
}
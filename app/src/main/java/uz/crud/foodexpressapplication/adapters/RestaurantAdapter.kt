package uz.crud.foodexpressapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.crud.foodexpressapplication.databinding.RestaurantItemLayoutBinding
import uz.crud.foodexpressapplication.models.response.restaurantFilter.RestaurantFilterResponse
import uz.crud.foodexpressapplication.utils.loadImage

interface RestaurantCallback {
    fun onClick(item: RestaurantFilterResponse, position: Int)
}

class RestaurantAdapter(
    val items: List<RestaurantFilterResponse>,
    val callback: RestaurantCallback
) :
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
        holder.binding.resImage.loadImage(item.main_image)
        holder.binding.tvName.text = item.name
        holder.binding.tvAddress.text = item.address
        holder.binding.tvReating.text = item.rating.toString()
        holder.binding.tvDistanse.text = item.distance.toString()

        holder.itemView.setOnClickListener {
            callback.onClick(item, position)
        }
    }
}
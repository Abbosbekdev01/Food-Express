package uz.crud.foodexpressapplication.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.crud.foodexpressapplication.R
import uz.crud.foodexpressapplication.databinding.CategoryTabItemLayoutBinding
import uz.crud.foodexpressapplication.models.CategoryModel

interface CategoryTanAdapterCallback {
    fun onClick(item: CategoryModel)
}

class CategoryTabAdapter(val items: List<CategoryModel>, val callback: CategoryTanAdapterCallback) :
    RecyclerView.Adapter<CategoryTabAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: CategoryTabItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            CategoryTabItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            items.forEach {
                it.active = false
            }
            item.active = true
            notifyDataSetChanged()
            callback.onClick(item)
        }
        holder.binding.tvName.setTextColor(
            if (item.active) ContextCompat.getColor(
                holder.itemView.context, R.color.color_accent
            ) else
                ContextCompat.getColor(holder.itemView.context, R.color.grey_color)
        )
    }
}
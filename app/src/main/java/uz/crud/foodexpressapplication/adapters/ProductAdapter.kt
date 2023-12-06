package uz.crud.foodexpressapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.crud.foodexpressapplication.databinding.ProductItemLayoutBinding
import uz.crud.foodexpressapplication.models.ProductModel

class ProductAdapter(val items: List<ProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: ProductItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ProductItemLayoutBinding.inflate(
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
    }
}
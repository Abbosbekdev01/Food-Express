package uz.crud.foodexpressapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.crud.foodexpressapplication.databinding.SlideItemLayoutBinding
import uz.crud.foodexpressapplication.models.SlideModel
import uz.crud.foodexpressapplication.models.response.offerModel.OfferModel
import uz.crud.foodexpressapplication.utils.Constants
import uz.crud.foodexpressapplication.utils.loadImage

class SlideAdapter(val items: List<OfferModel>) : RecyclerView.Adapter<SlideAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: SlideItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            SlideItemLayoutBinding.inflate(
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
        holder.binding.tvTitle.text = item.title
        holder.binding.image.loadImage(item.image)
    }


}
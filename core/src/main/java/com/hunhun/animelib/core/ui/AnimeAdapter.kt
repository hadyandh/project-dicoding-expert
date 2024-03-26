package com.hunhun.animelib.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hunhun.animelib.core.R
import com.hunhun.animelib.core.databinding.RowItemAnimeBinding
import com.hunhun.animelib.core.domain.model.Anime

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {

    var onItemClick: ((Anime) -> Unit)? = null

    private val diffUtil = object : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem == newItem
        }
    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    fun setData(newListData: List<Anime>?) {
        asyncListDiffer.submitList(newListData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_anime, parent, false))

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = asyncListDiffer.currentList[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RowItemAnimeBinding.bind(itemView)
        fun bind(data: Anime) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.banner)
                    .into(bannerIV)
                titleTV.text = data.title

                root.setOnClickListener {
                    onItemClick?.invoke(data)
                }
            }
        }
    }
}
package com.dicoding.submission.thesports.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submission.thesports.commons.databinding.ItemListSportsBinding
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel

class EventAdapter: RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private var list: List<EventDomainModel> = listOf()

    fun submitList(list: List<EventDomainModel>){
        this.list = list
        notifyItemRangeInserted(0, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListSportsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(
        private val binding: ItemListSportsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: EventDomainModel){
            binding.homeName.text = data.homeTeam
            binding.awayName.text = data.awayTeam
            binding.homeScore.text = data.homeScore
            binding.awayScore.text = data.awayScore
            binding.eventDate.text = data.dataEvent.replace("-","/")
        }
    }
}
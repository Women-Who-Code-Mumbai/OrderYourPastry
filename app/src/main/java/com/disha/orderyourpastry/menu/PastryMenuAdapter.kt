package com.disha.orderyourpastry.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.disha.orderyourpastry.R
import com.disha.orderyourpastry.databinding.ItemPastryRowBinding

class PastryMenuAdapter(
    private val context: Context,
    private val presenter: MenuContract.AdapterPresenter
) : RecyclerView.Adapter<PastryMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_pastry_row,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return presenter.getAdapterCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(presenter.getAdapterEntity(position))
    }

    inner class ViewHolder(private val binding: ItemPastryRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.clRoot.setOnClickListener {
                presenter.itemClicked(adapterPosition)
            }
        }

        fun bind(pastryDataModel: PastryDataModel) {
            with(binding) {
                with(pastryDataModel) {
                    tvPastryName.text = pastryName
                    ivPastry.setImageResource(resourceId)
                }
            }
        }
    }

}
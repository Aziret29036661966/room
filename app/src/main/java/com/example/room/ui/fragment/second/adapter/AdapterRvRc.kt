package com.example.room.ui.fragment.second.adapter

import android.annotation.SuppressLint
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.databinding.ItemBinding
import com.example.room.model.entity.History

class AdapterRvRc(private val onClick: Boolean): RecyclerView.Adapter<AdapterRvRc.ViewHolder>() {

    private var list = listOf<History>()

    @SuppressLint("NotifyDataSetChanged")
    fun setResult(lists: List<History>){
        this.list = lists
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        val binding: ItemBinding
    ): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customItem = list[position]

        with(holder.binding){
            txtResultCalculate.text = customItem.result
            txtDataCalculate.text = customItem.data
            if (position % 2 == 0) {
                holder.itemView.setBackgroundResource(R.color.white)
            } else {
                holder.itemView.setBackgroundResource(R.color.gray_dark)
                txtResultCalculate.setTextColor(R.color.white)
                txtDataCalculate.setTextColor(R.color.white)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnClick{
        fun click(pos:Int)
    }

}

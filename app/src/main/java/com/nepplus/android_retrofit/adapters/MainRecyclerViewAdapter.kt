package com.nepplus.android_retrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nepplus.android_retrofit.R
import com.nepplus.android_retrofit.databinding.ListItemGoalBinding
import com.nepplus.android_retrofit.databinding.ListItemHeaderBinding
import com.nepplus.android_retrofit.databinding.ListItemItemBinding
import com.nepplus.android_retrofit.models.GoalData
import com.nepplus.android_retrofit.models.GroupData

class MainRecyclerViewAdapter(val mContext : Context, val mList : List<GroupData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_HEADER = 0
    val TYPE_ITEM = 1

    lateinit var headerBinding : ListItemHeaderBinding
    lateinit var itemBinding : ListItemItemBinding
    lateinit var goalBinding : ListItemGoalBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                headerBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(mContext),
                    R.layout.list_item_header,
                    parent,
                    false)
                HeaderViewHolder(headerBinding.root)
            }
            else -> {
                itemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(mContext),
                    R.layout.list_item_item,
                    parent,
                    false)
                HeaderViewHolder(itemBinding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                holder.bindPage()
            }
            is ItemViewHolder -> {
                holder.bind(mList[position-1])
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size + 1
    }

    inner class HeaderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindPage(){

        }
    }

    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(item : GroupData){

        }
    }
}
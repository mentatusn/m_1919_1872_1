package com.gb.m_1919_1872_1.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_1919_1872_1.R
import com.gb.m_1919_1872_1.databinding.ActivityRecyclerItemEarthBinding
import com.gb.m_1919_1872_1.databinding.ActivityRecyclerItemMarsBinding
import kotlinx.coroutines.NonDisposableHandle.parent

const val TYPE_EARTH = 1
const val TYPE_MARS = 2
class RecyclerActivityAdapter(private var list: List<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_EARTH -> {
                val view = ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(view.root)
            }
            TYPE_MARS -> {
                val view = ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
            else -> {
                val view = ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){ // TODO WH создать BaseViewHolder
            TYPE_EARTH -> {
                (holder as EarthViewHolder).myBind(list[position])
            }
            TYPE_MARS -> {
                (holder as MarsViewHolder).myBind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class EarthViewHolder(view: View):RecyclerView.ViewHolder(view){ // TODO WH :BaseViewHolder
        fun myBind(data:Data){
            /*(itemView as ConstraintLayout).findViewById<TextView>(R.id.title).text = data.someText
            (itemView as ConstraintLayout).findViewById<TextView>(R.id.descriptionTextView).text = data.someDescription*/

            /*val binding = ActivityRecyclerItemEarthBinding.bind(itemView)
            binding.title.text =data.someText
            binding.descriptionTextView.text = data.someDescription*/

            (ActivityRecyclerItemEarthBinding.bind(itemView)).apply {
                title.text =data.someText
                descriptionTextView.text = data.someDescription
            }
        }
    }
    class MarsViewHolder(view: View):RecyclerView.ViewHolder(view){ // TODO WH :BaseViewHolder
        fun myBind(data:Data){
                (ActivityRecyclerItemMarsBinding.bind(itemView)).apply {
                title.text =data.someText
            }
        }
    }
}
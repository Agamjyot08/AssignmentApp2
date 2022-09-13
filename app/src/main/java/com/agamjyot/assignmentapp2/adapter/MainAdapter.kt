package com.agamjyot.assignmentapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agamjyot.assignmentapp2.R
import com.agamjyot.assignmentapp2.databinding.RecyclerItemBinding

class MainAdapter(private var items: ArrayList<String>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var row: Int = 0
    private var col: Int = 0
    val blacklistRowCol = mutableListOf<Pair<Int, Int>>()
    var secondIndex = -1
    val allIndexes = mutableListOf<Pair<Int, Int>>()

    init {
        for (i in 0 until 5) {
            for (j in 0 until 5) {
                allIndexes.add(i to j)
            }
        }
    }

    inner class ViewHolder(var itemBinding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val indexPos = (row * 5) + col
        holder.itemBinding.ivPic.setImageResource(R.color.white)
        if (position == indexPos) {
            holder.itemBinding.ivPic.setImageResource(R.drawable.ic_baseline_add_circle_24)
        }
        if (secondIndex == position) {
            holder.itemBinding.ivPic.setImageResource(R.drawable.ic_baseline_indeterminate_check_box_24)
        }

    }

    fun setFirstImagePosition(row: Int, col: Int) {
        this.row = row
        this.col = col
        blacklistRowCol.clear()
        repeat(5) {
            blacklistRowCol.add(row to it)
        }
        repeat(5) {
            blacklistRowCol.add(it to col)
        }
        allIndexes.first { !blacklistRowCol.contains(it) }.apply {
            secondIndex = (first * 5) + second
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
package com.rightpoint.common.android.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter

class BaseAdapter<I : Item> : ListAdapter<I, BaseViewHolder>(ItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        item?.bind(holder)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val item = getItem(position)
            item?.bind(holder, payloads)
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemId(position: Int): Long = getItem(position).uniqueId()

    override fun getItemViewType(position: Int): Int = getItem(position).layoutId()

    fun newSpanSizeLookup(): GridLayoutManager.SpanSizeLookup {
        return object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return getItem(position).spanSize()
            }
        }
    }
}
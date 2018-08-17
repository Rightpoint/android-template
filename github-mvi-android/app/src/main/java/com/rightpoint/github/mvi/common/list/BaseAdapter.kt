package com.rightpoint.github.mvi.common.list

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup

class BaseAdapter<I : Item> : ListAdapter<I, BaseViewHolder>(
    ItemDiffCallback<I>()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        item?.bind(holder)
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
package com.rightpoint.github.mvi.common.list

import android.support.v7.util.DiffUtil
import java.util.Objects

class ItemDiffCallback<I : Item> : DiffUtil.ItemCallback<I>() {
    override fun areItemsTheSame(oldItem: I, newItem: I): Boolean {
        return oldItem.uniqueId() == newItem.uniqueId()
    }

    override fun areContentsTheSame(oldItem: I, newItem: I): Boolean {
        return Objects.equals(oldItem, newItem)
    }
}
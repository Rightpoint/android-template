package com.rightpoint.common.android.list

import androidx.annotation.LayoutRes

interface Item {
    @LayoutRes fun layoutId(): Int
    fun uniqueId(): Long
    fun bind(holder: BaseViewHolder)
    fun bind(holder: BaseViewHolder, payloads: MutableList<Any>) {
        bind(holder)
    }
    fun spanSize(): Int = 1
}
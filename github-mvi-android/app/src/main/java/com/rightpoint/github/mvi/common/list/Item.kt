package com.rightpoint.github.mvi.common.list

import android.support.annotation.LayoutRes

interface Item {
    @LayoutRes fun layoutId(): Int
    fun uniqueId(): Long
    fun bind(holder: BaseViewHolder)
    fun spanSize(): Int = 1
}
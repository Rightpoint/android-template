package com.rightpoint.github.mvi.repos

import androidx.view.isVisible
import com.rightpoint.github.mvi.R
import com.rightpoint.github.mvi.common.list.BaseViewHolder
import com.rightpoint.github.mvi.common.list.Item
import kotlinx.android.synthetic.main.list_item_state.view.*

data class StateItem(
    val state: State,
    val onRetry: () -> Unit = {}
) : Item {
    override fun layoutId(): Int = R.layout.list_item_state

    override fun uniqueId(): Long = state.hashCode().toLong()

    override fun bind(holder: BaseViewHolder) {
        when (state) {
            is State.Loading -> {
                holder.itemView.error_message.isVisible = false
                holder.itemView.retry_button.isVisible = false
                holder.itemView.loading.isVisible = true
            }
            is State.Error -> {
                holder.itemView.error_message.isVisible = true
                holder.itemView.error_message.text = state.error.message
                holder.itemView.retry_button.isVisible = true
                holder.itemView.retry_button.setOnClickListener {
                    onRetry()
                }
                holder.itemView.loading.isVisible = false
            }
            else -> {
                holder.itemView.error_message.isVisible = false
                holder.itemView.retry_button.isVisible = false
                holder.itemView.loading.isVisible = false
            }
        }
    }
}
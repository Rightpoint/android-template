package com.rightpoint.github.mvi.repos

import com.rightpoint.github.mvi.GlideApp
import com.rightpoint.github.mvi.R
import com.rightpoint.github.mvi.common.list.BaseViewHolder
import com.rightpoint.github.mvi.common.list.Item
import kotlinx.android.synthetic.main.list_item_repo.view.*

data class RepoItem(
    val id: Long,
    val name: String,
    val description: String?,
    val ownerAvatarUrl: String,
    val forks: Int,
    val stars: Int,
    val watchers: Int
) : Item {
    override fun layoutId(): Int = R.layout.list_item_repo

    override fun uniqueId(): Long = id

    override fun bind(holder: BaseViewHolder) {
        GlideApp.with(holder.itemView.context)
            .load(ownerAvatarUrl)
            .circleCrop()
            .into(holder.itemView.avatar)
        holder.itemView.repo_name.text = name
        holder.itemView.repo_description.text = description
        holder.itemView.fork.text = forks.toString()
        holder.itemView.star.text = stars.toString()
        holder.itemView.watch.text = watchers.toString()
    }
}
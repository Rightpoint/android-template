package com.rightpoint.mvi.example.repo.model

import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import com.rightpoint.common.android.list.BaseViewHolder
import com.rightpoint.common.android.list.Item
import com.rightpoint.mvi.example.R
import kotlinx.android.synthetic.main.list_item_repo_grid.view.*

data class RepoItem(
    val id: Long,
    val name: String,
    val description: String?,
    val ownerAvatarUrl: String,
    val htmlUrl: String,
    val forks: Int,
    val stars: Int,
    val watchers: Int,
    val openIssues: Int,
    val onCommitClick: ((String) -> Unit)? = null
) : Item {
    override fun layoutId(): Int = R.layout.list_item_repo_grid

    override fun uniqueId(): Long = id

    override fun bind(holder: BaseViewHolder) {
        holder.itemView.repoName.text = name
        holder.itemView.repoDescription.text = description
        holder.itemView.openIssues.text = openIssues.toString()
        holder.itemView.setOnClickListener {
            CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .build()
                .launchUrl(holder.itemView.context, htmlUrl.toUri())
        }
        holder.itemView.commits.setOnClickListener {
            onCommitClick?.invoke(name)
        }
        holder.itemView.openIssues.setOnClickListener {
            CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .build()
                .launchUrl(
                    holder.itemView.context,
                    htmlUrl.toUri()
                        .buildUpon()
                        .appendPath("issues")
                        .build()
                )
        }
    }
}
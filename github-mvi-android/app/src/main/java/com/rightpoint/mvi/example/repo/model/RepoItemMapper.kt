package com.rightpoint.mvi.example.repo.model

import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.domain.model.RepoModel

class RepoItemMapper(private val onCommitClick: ((String) -> Unit)?) : Mapper<RepoModel, RepoItem> {
    override fun map(t: RepoModel): RepoItem {
        return RepoItem(
            id = t.id,
            name = t.name,
            description = t.description,
            ownerAvatarUrl = t.owner.avatarUrl,
            htmlUrl = t.htmlUrl,
            forks = t.forksCount,
            stars = t.stargazersCount,
            watchers = t.watchersCount,
            openIssues = t.openIssuesCount,
            onCommitClick = onCommitClick
        )
    }
}
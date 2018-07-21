package com.rightpoint.github.mvi.data.mapper.model

import com.rightpoint.github.mvi.cache.room.model.RepoEntity
import com.rightpoint.github.mvi.domain.common.Mapper
import com.rightpoint.github.mvi.domain.model.RepoModel
import javax.inject.Inject

class RepoModelMapper @Inject constructor(
    private val ownerMapper: OwnerModelMapper
) : Mapper<RepoEntity, RepoModel> {
    override fun map(t: RepoEntity): RepoModel {
        return RepoModel(
            t.id,
            t.name,
            t.full_name,
            ownerMapper.map(t.owner),
            t.is_private,
            t.html_url,
            t.description,
            t.fork,
            t.url,
            t.stargazers_count,
            t.watchers_count,
            t.language,
            t.has_issues,
            t.has_projects,
            t.has_downloads,
            t.has_wiki,
            t.has_pages,
            t.forks_count,
            t.open_issues_count
        )
    }
}
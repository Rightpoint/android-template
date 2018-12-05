package com.rightpoint.mvi.example.data.mapper.entities

import com.rightpoint.mvi.example.cache.room.model.RepoEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.remote.model.Repo
import javax.inject.Inject

class RepoEntityMapper @Inject constructor(
    private val ownerMapper: OwnerEntityMapper
) : Mapper<Repo, RepoEntity> {
    override fun map(t: Repo): RepoEntity {
        return RepoEntity(
            t.id,
            t.name,
            t.full_name,
            ownerMapper.map(t.owner)!!,
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
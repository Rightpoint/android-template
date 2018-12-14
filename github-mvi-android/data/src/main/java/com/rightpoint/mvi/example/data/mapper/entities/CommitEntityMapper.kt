package com.rightpoint.mvi.example.data.mapper.entities

import com.rightpoint.mvi.example.cache.room.model.CommitEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.remote.model.Commit
import javax.inject.Inject

class CommitEntityMapper @Inject constructor(
    private val metadataMapper: CommitMetadataEntityMapper,
    private val ownerMapper: OwnerEntityMapper
) : Mapper<Commit, CommitEntity> {
    override fun map(t: Commit): CommitEntity {
        return CommitEntity(
            sha = t.sha,
            commit = metadataMapper.map(t.commit),
            url = t.url,
            html_url = t.html_url,
            comments_url = t.comments_url,
            author = ownerMapper.map(t.author),
            committer = ownerMapper.map(t.committer)
        )
    }
}
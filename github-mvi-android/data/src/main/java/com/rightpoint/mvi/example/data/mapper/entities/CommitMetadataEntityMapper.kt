package com.rightpoint.mvi.example.data.mapper.entities

import com.rightpoint.mvi.example.cache.room.model.CommitMetadataEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.remote.model.Commit
import javax.inject.Inject

class CommitMetadataEntityMapper
@Inject constructor() : Mapper<Commit.Metadata, CommitMetadataEntity> {
    override fun map(t: Commit.Metadata): CommitMetadataEntity {
        return CommitMetadataEntity(
            id = 0,
            message = t.message,
            comment_count = t.comment_count
        )
    }
}
package com.rightpoint.mvi.example.data.mapper.model

import com.rightpoint.mvi.example.cache.room.model.CommitEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.domain.model.CommitModel
import javax.inject.Inject

class CommitModelMapper @Inject constructor(
    private val ownerMapper: OwnerModelMapper
) : Mapper<CommitEntity, CommitModel> {
    override fun map(t: CommitEntity): CommitModel {
        return CommitModel(
            sha = t.sha,
            message = t.commit.message,
            commentCount = t.commit.comment_count,
            url = t.url,
            htmlUrl = t.html_url,
            commentsUrl = t.comments_url,
            author = ownerMapper.map(t.author),
            committer = ownerMapper.map(t.committer)
        )
    }
}
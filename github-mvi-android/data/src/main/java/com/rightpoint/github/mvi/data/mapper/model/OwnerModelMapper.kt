package com.rightpoint.github.mvi.data.mapper.model

import com.rightpoint.github.mvi.cache.room.model.OwnerEntity
import com.rightpoint.github.mvi.domain.common.Mapper
import com.rightpoint.github.mvi.domain.model.OwnerModel
import javax.inject.Inject

class OwnerModelMapper @Inject constructor() : Mapper<OwnerEntity, OwnerModel> {
    override fun map(t: OwnerEntity): OwnerModel {
        return OwnerModel(
            t.login,
            t.id,
            t.avatar_url,
            t.url,
            t.html_url,
            t.type
        )
    }
}
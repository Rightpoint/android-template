package com.rightpoint.github.mvi.data.mapper.entities

import com.rightpoint.github.mvi.cache.room.model.OwnerEntity
import com.rightpoint.github.mvi.domain.common.Mapper
import com.rightpoint.github.mvi.remote.model.Owner
import javax.inject.Inject

class OwnerEntityMapper @Inject constructor() : Mapper<Owner, OwnerEntity> {
    override fun map(t: Owner): OwnerEntity {
        return OwnerEntity(
            t.login,
            t.id,
            t.avatar_url,
            t.url,
            t.html_url,
            t.type
        )
    }
}
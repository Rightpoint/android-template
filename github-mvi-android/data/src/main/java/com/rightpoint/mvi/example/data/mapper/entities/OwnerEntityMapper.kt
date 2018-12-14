package com.rightpoint.mvi.example.data.mapper.entities

import com.rightpoint.mvi.example.cache.room.model.OwnerEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.remote.model.Owner
import javax.inject.Inject

class OwnerEntityMapper @Inject constructor() : Mapper<Owner?, OwnerEntity?> {
    override fun map(t: Owner?): OwnerEntity? {
        if (t == null) return null
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
package com.rightpoint.mvi.example.data.mapper.model

import com.rightpoint.mvi.example.cache.room.model.OwnerEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.domain.model.OwnerModel
import javax.inject.Inject

class OwnerModelMapper @Inject constructor() : Mapper<OwnerEntity?, OwnerModel?> {
    override fun map(t: OwnerEntity?): OwnerModel? {
        if (t == null) return null
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
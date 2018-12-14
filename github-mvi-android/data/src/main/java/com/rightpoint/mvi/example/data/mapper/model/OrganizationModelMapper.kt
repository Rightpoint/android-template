package com.rightpoint.mvi.example.data.mapper.model

import com.rightpoint.mvi.example.cache.room.model.OrganizationEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.domain.model.OrganizationModel
import javax.inject.Inject

class OrganizationModelMapper
@Inject constructor() : Mapper<OrganizationEntity, OrganizationModel> {
    override fun map(t: OrganizationEntity): OrganizationModel {
        return OrganizationModel(
            t.login,
            t.id,
            t.avatar_url,
            t.url,
            t.html_url
        )
    }
}
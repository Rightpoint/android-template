package com.rightpoint.github.mvi.data.mapper.model

import com.rightpoint.github.mvi.cache.room.model.OrganizationEntity
import com.rightpoint.github.mvi.domain.common.Mapper
import com.rightpoint.github.mvi.domain.model.OrganizationModel
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
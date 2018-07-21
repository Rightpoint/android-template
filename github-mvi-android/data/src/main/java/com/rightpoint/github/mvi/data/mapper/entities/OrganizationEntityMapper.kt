package com.rightpoint.github.mvi.data.mapper.entities

import com.rightpoint.github.mvi.cache.room.model.OrganizationEntity
import com.rightpoint.github.mvi.domain.common.Mapper
import com.rightpoint.github.mvi.remote.model.Organization
import javax.inject.Inject

class OrganizationEntityMapper @Inject constructor() : Mapper<Organization, OrganizationEntity> {
    override fun map(t: Organization): OrganizationEntity {
        return OrganizationEntity(
            t.login,
            t.id,
            t.avatar_url,
            t.url,
            t.html_url
        )
    }
}
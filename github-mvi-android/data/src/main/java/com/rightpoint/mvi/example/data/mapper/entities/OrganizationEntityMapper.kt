package com.rightpoint.mvi.example.data.mapper.entities

import com.rightpoint.mvi.example.cache.room.model.OrganizationEntity
import com.rightpoint.mvi.example.domain.common.Mapper
import com.rightpoint.mvi.example.remote.model.Organization
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
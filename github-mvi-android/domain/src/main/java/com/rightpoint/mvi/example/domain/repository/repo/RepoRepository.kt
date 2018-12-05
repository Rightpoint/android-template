package com.rightpoint.mvi.example.domain.repository.repo

import com.rightpoint.mvi.example.domain.model.RepoModel
import io.reactivex.Flowable

/**
 * Unfortunately named interface
 */
interface RepoRepository {
    fun getListOfReposByOrg(org: String): Flowable<List<RepoModel>>
    fun getRepo(owner: String, repo: String): Flowable<RepoModel>
}
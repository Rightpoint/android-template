package com.rightpoint.mvi.example.remote

import com.rightpoint.mvi.example.remote.model.Commit
import com.rightpoint.mvi.example.remote.model.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{org}/repos")
    fun getListOfReposByOrg(@Path("org") org: String): Single<List<Repo>>

    @GET("repos/{owner}/{repo}")
    fun getRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Single<Repo>

    @GET("repos/{owner}/{repo}/commits")
    fun getListOfCommitsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Single<List<Commit>>
}
package com.rightpoint.github.mvi.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0007H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/rightpoint/github/mvi/remote/GithubApi;", "", "getListOfReposByOrg", "Lio/reactivex/Single;", "", "Lcom/rightpoint/github/mvi/remote/model/Repo;", "org", "", "getRepo", "owner", "repo", "remote_debug"})
public abstract interface GithubApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "users/{org}/repos")
    public abstract io.reactivex.Single<java.util.List<com.rightpoint.github.mvi.remote.model.Repo>> getListOfReposByOrg(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "org")
    java.lang.String org);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "repos/{owner}/{repo}")
    public abstract io.reactivex.Single<com.rightpoint.github.mvi.remote.model.Repo> getRepo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "owner")
    java.lang.String owner, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "repo")
    java.lang.String repo);
}
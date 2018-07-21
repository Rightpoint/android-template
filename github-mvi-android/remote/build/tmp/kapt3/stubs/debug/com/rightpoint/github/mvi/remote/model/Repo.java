package com.rightpoint.github.mvi.remote.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0010H\u00c6\u0003J\t\u00104\u001a\u00020\u0010H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\nH\u00c6\u0003J\t\u00107\u001a\u00020\nH\u00c6\u0003J\t\u00108\u001a\u00020\nH\u00c6\u0003J\t\u00109\u001a\u00020\nH\u00c6\u0003J\t\u0010:\u001a\u00020\nH\u00c6\u0003J\t\u0010;\u001a\u00020\u0010H\u00c6\u0003J\t\u0010<\u001a\u00020\u0010H\u00c6\u0003J\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\bH\u00c6\u0003J\t\u0010@\u001a\u00020\nH\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010C\u001a\u00020\nH\u00c6\u0003J\t\u0010D\u001a\u00020\u0005H\u00c6\u0003J\u00cb\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010H\u001a\u00020\u0010H\u00d6\u0001J\t\u0010I\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 \u00a8\u0006J"}, d2 = {"Lcom/rightpoint/github/mvi/remote/model/Repo;", "", "id", "", "name", "", "full_name", "owner", "Lcom/rightpoint/github/mvi/remote/model/Owner;", "is_private", "", "html_url", "description", "fork", "url", "stargazers_count", "", "watchers_count", "language", "has_issues", "has_projects", "has_downloads", "has_wiki", "has_pages", "forks_count", "open_issues_count", "(JLjava/lang/String;Ljava/lang/String;Lcom/rightpoint/github/mvi/remote/model/Owner;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;IILjava/lang/String;ZZZZZII)V", "getDescription", "()Ljava/lang/String;", "getFork", "()Z", "getForks_count", "()I", "getFull_name", "getHas_downloads", "getHas_issues", "getHas_pages", "getHas_projects", "getHas_wiki", "getHtml_url", "getId", "()J", "getLanguage", "getName", "getOpen_issues_count", "getOwner", "()Lcom/rightpoint/github/mvi/remote/model/Owner;", "getStargazers_count", "getUrl", "getWatchers_count", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "remote_debug"})
public final class Repo {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String full_name = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rightpoint.github.mvi.remote.model.Owner owner = null;
    private final boolean is_private = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String html_url = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    private final boolean fork = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    private final int stargazers_count = 0;
    private final int watchers_count = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String language = null;
    private final boolean has_issues = false;
    private final boolean has_projects = false;
    private final boolean has_downloads = false;
    private final boolean has_wiki = false;
    private final boolean has_pages = false;
    private final int forks_count = 0;
    private final int open_issues_count = 0;
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFull_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rightpoint.github.mvi.remote.model.Owner getOwner() {
        return null;
    }
    
    public final boolean is_private() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHtml_url() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean getFork() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final int getStargazers_count() {
        return 0;
    }
    
    public final int getWatchers_count() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final boolean getHas_issues() {
        return false;
    }
    
    public final boolean getHas_projects() {
        return false;
    }
    
    public final boolean getHas_downloads() {
        return false;
    }
    
    public final boolean getHas_wiki() {
        return false;
    }
    
    public final boolean getHas_pages() {
        return false;
    }
    
    public final int getForks_count() {
        return 0;
    }
    
    public final int getOpen_issues_count() {
        return 0;
    }
    
    public Repo(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, @org.jetbrains.annotations.NotNull()
    com.rightpoint.github.mvi.remote.model.Owner owner, @com.squareup.moshi.Json(name = "private")
    boolean is_private, @org.jetbrains.annotations.NotNull()
    java.lang.String html_url, @org.jetbrains.annotations.Nullable()
    java.lang.String description, boolean fork, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int stargazers_count, int watchers_count, @org.jetbrains.annotations.Nullable()
    java.lang.String language, boolean has_issues, boolean has_projects, boolean has_downloads, boolean has_wiki, boolean has_pages, int forks_count, int open_issues_count) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rightpoint.github.mvi.remote.model.Owner component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rightpoint.github.mvi.remote.model.Repo copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, @org.jetbrains.annotations.NotNull()
    com.rightpoint.github.mvi.remote.model.Owner owner, @com.squareup.moshi.Json(name = "private")
    boolean is_private, @org.jetbrains.annotations.NotNull()
    java.lang.String html_url, @org.jetbrains.annotations.Nullable()
    java.lang.String description, boolean fork, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int stargazers_count, int watchers_count, @org.jetbrains.annotations.Nullable()
    java.lang.String language, boolean has_issues, boolean has_projects, boolean has_downloads, boolean has_wiki, boolean has_pages, int forks_count, int open_issues_count) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
}
package utils

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.ObjectId
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.eclipse.jgit.revwalk.filter.RevFilter
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GitHelper(rootDir: File) {
    private val repo: Repository = FileRepositoryBuilder()
        .setGitDir(File(rootDir, ".git"))
        .build()
    private val git: Git = Git(repo)

    fun getDevelopReleaseNotes(): Notes {
        return Notes(
            log = git.getLogForPreviousMerge(),
            branch = repo.branch,
            commit = git.latestCommitSha
        )
    }

    fun getSprintReleaseNotes(): Notes {
        return Notes(
            log = git.getLogForPreviousSprint(),
            branch = repo.branch,
            commit = git.latestCommitSha
        )
    }

    fun getProductionReleaseNotes(): Notes {
        return Notes(
            log = git.getLogForPreviousRelease(),
            branch = repo.branch,
            commit = git.latestCommitSha
        )
    }

    private val Git.latestCommitSha: String?
        get() = log().call().firstOrNull()?.toObjectId()?.abbreviate(8)?.name()

    private fun Git.getLogForPreviousMerge(): Iterable<RevCommit> {
        return gitLogFor {
            try {
                log().setRevFilter(RevFilter.ONLY_MERGES).call()
                    .reversed().map { it.toObjectId() }
            } catch (e: NoHeadException) {
                commit().setMessage("Initial commit").call()
                log().all().setRevFilter(RevFilter.NO_MERGES).call()
                    .reversed().map { it.toObjectId() }
            }
        }
    }

    private fun Git.getLogForPreviousTag(): Iterable<RevCommit> {
        return gitLogFor { tagList().call().map { it.objectId } }
    }

    private fun Git.getLogForPreviousSprint(): Iterable<RevCommit> {
        return gitLogFor {
            tagList().call().filter { ref -> ref.name.contains(Regex("sprint-*")) }.map { it.objectId }
        }
    }

    private fun Git.getLogForPreviousRelease(): Iterable<RevCommit> {
        return gitLogFor {
            tagList().call().filter { ref -> ref.name.contains(Regex("release-*")) }.map { it.objectId }
        }
    }

    private inline fun Git.gitLogFor(hashList: () -> List<ObjectId>): Iterable<RevCommit> {
        val hashes = hashList()
        val command = when {
            hashes.isEmpty() -> log().all()
            hashes.size == 1 -> log().add(hashes[0])
            else -> {
                val previousTwoReferences = hashes.takeLast(2)
                log().addRange(previousTwoReferences[0], previousTwoReferences[1])
            }
        }.setRevFilter(RevFilter.NO_MERGES)
        return command.call()
    }
}

/**
 * A class for representing the HockeyApp release notes. The {@link #toString} method
 * generates a properly formatted Markdown message.
 */
data class Notes(
    val log: Iterable<RevCommit>,
    val branch: String? = null,
    val commit: String? = null,
    val testId: String? = null
) {
    private val commitFormatter = SimpleDateFormat("[yyyy-MM-dd]", Locale.US)
    private val buildDateTime: String = SimpleDateFormat("E dd-MMM-yyyy hh:mm a", Locale.US)
        .format(Date())

    override fun toString(): String {
        return buildString {
            append("### Built on: ")
            append(buildDateTime)
            append("\n")
            if (branch != null) {
                append("### Branch: ")
                append(branch)
                append("\n")
            }
            if (commit != null) {
                append("### Commit: ")
                append(commit)
                append("\n")
            }
            if (testId != null) {
                append("### Test ID: ")
                append(testId)
                append("\n")
            }
            for (commit in log) {
                val author = commit.authorIdent
                append('*')
                append(' ')
                append(commitFormatter.format(author.`when`))
                append(' ')
                append(commit.shortMessage)
                append(' ')
                append('(')
                append(author.name)
                append(')')
                append(' ')
                append(' ')
                append("\n")
            }
        }
    }
}
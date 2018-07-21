package com.rightpoint.github.mvi.data

import com.rightpoint.github.mvi.domain.executors.AppExecutors
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.lang.RuntimeException

@RunWith(JUnit4::class)
class NetworkBoundResourceTest {

    companion object {
        private val LOCAL_DATABASE = Local("This is from the database.")
        private val LOCAL_NETWORK = Local("This is from the network.")
    }

    @Test
    fun testDatabaseMiss() {
        Stub().asFlowable()
                .test()
                .assertValue(LOCAL_NETWORK)
    }

    @Test
    fun testDatabaseHit() {
        Stub().apply {
            mockDb.onNext(LOCAL_DATABASE)
            shouldFetch = false
        }.asFlowable()
                .test()
                .assertValue(LOCAL_DATABASE)
    }

    @Test
    fun testStaleDatabaseHit() {
        Stub().apply {
            mockDb.onNext(LOCAL_DATABASE)
        }.asFlowable()
                .test()
                .assertValues(LOCAL_NETWORK)
    }

    /**
     * A test class to stub local/database values.
     */
    private data class Local(val value: String)

    /**
     * A test class to stub remote/network values.
     */
    private data class Remote(val value: String)

    /**
     * The purpose of this class is to stub out the database/network external
     * interfaces and test the logic inside of NetworkBoundResource
     */
    private class Stub : NetworkBoundResource<Remote, Local>(TestExecutors()) {
        val mockDb: BehaviorSubject<Local> = BehaviorSubject.create()
        var shouldFetch: Boolean = true

        override fun checkDb(): Single<Local> {
            return Single.fromCallable {
                mockDb.value ?: throw RuntimeException("Empty set.")
            }
        }

        override fun openDbConnection(): Flowable<Local> {
            return mockDb.toFlowable(BackpressureStrategy.MISSING)
        }

        override fun shouldFetch(data: Local): Boolean {
            return shouldFetch
        }

        override fun saveToDb(data: Local) {
            mockDb.onNext(data)
        }

        override fun fetchFromNetwork(): Single<Remote> {
            return Single.just(Remote("This is from the network."))
        }

        override fun mapTo(data: Remote): Local {
            return Local(data.value)
        }
    }

    /**
     * Executors specifically for testing everything on the same thread
     */
    private class TestExecutors : AppExecutors {
        override fun diskIo(): Scheduler = Schedulers.trampoline()
        override fun networkIo(): Scheduler = Schedulers.trampoline()
        override fun mainThread(): Scheduler = Schedulers.trampoline()
    }
}
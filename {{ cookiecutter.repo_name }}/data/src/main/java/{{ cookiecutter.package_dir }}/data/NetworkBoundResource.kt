package {{ cookiecutter.package_name }}.data

import android.support.annotation.WorkerThread
import {{ cookiecutter.package_name }}.domain.executors.AppExecutors
import io.reactivex.Flowable
import io.reactivex.Single

internal abstract class NetworkBoundResource<RemoteType, LocalType>
constructor(private val executors: AppExecutors) {

    fun asFlowable(): Flowable<LocalType> {
        return checkDb().subscribeOn(executors.diskIo())
                .flatMapPublisher {
                    if (shouldFetch(it)) {
                        fetchFromNetworkAndSave()
                    } else {
                        openDbConnection().subscribeOn(executors.diskIo())
                    }
                }
                .onErrorResumeNext(fetchFromNetworkAndSave())
                .observeOn(executors.mainThread())
    }

    private fun fetchFromNetworkAndSave(): Flowable<LocalType> {
        return fetchFromNetwork().subscribeOn(executors.networkIo())
                .map(this::mapTo)
                .observeOn(executors.diskIo())
                .doOnSuccess(this::saveToDb)
                .flatMapPublisher { openDbConnection() }
    }

    /**
     * Makes a query to the database to check if the value exists.  Returns a Single of the value
     * if it exists or an error if it doesn't exist.
     */
    abstract fun checkDb(): Single<LocalType>

    /**
     * Opens a Flowable connection to the database that emits new values whenever an update to the
     * database occurs.
     */
    abstract fun openDbConnection(): Flowable<LocalType>

    /**
     * Returns a boolean which is true if the NetworkBoundResource should fetch fresh data from the
     * server or false if it should just return the data cached in the local database.
     */
    abstract fun shouldFetch(data: LocalType): Boolean

    @WorkerThread abstract fun saveToDb(data: LocalType)

    abstract fun fetchFromNetwork(): Single<RemoteType>

    /**
     * Maps the remote data from the network to a type that can be stored locally in the database.
     */
    abstract fun mapTo(data: RemoteType): LocalType
}
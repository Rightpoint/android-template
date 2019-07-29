package {{ cookiecutter.package_name }}.domain.interactor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

abstract class CoroutineUseCase<in T, out R> {
    operator fun invoke(
            scope: CoroutineScope,
            params: T,
            onResult: (Result<out R>) -> Unit = {}
    ) {
        val backgroundJob = scope.async {
            try {
                Result.success(execute(params))
            } catch (e: Exception) {
                Result.failure<R>(e)
            }
        }
        scope.launch { onResult(backgroundJob.await()) }
    }

    protected abstract suspend fun execute(params: T): R
}
package {{ cookiecutter.package_name }}.domain.interactor

abstract class CoroutineUseCase<in T, out R> {
    suspend operator fun invoke(params: T): R {
        return execute(params)
    }

    protected abstract suspend fun execute(params: T): R
}

suspend operator fun <R> CoroutineUseCase<Unit, R>.invoke(): R = this(Unit)
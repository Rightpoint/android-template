package {{ cookiecutter.package_name }}.domain.interactor


sealed class Result<T> {
    fun isSuccessful() = this is Success

    class Success<T>(val data: T) : Result<T>()
    class Failure<T>(val error: Throwable) : Result<T>()

    companion object {
        fun <T> success(data: T): Success<T> = Success(data)
        fun <T> failure(error: Throwable): Failure<T> = Failure(error)
    }
}
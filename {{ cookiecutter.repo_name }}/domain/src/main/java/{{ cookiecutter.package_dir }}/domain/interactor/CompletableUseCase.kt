package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Completable

abstract class CompletableUseCase<in T> : BaseUseCase<T, Completable>()
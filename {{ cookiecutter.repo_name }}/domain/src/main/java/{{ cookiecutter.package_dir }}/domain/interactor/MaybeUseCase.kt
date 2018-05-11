package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Maybe

abstract class MaybeUseCase<in T, R> : UseCase<T, Maybe<R>>
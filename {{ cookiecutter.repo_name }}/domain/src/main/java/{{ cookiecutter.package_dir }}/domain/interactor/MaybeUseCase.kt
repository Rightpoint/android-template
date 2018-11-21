package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Maybe

abstract class MaybeUseCase<in T, R> : BaseUseCase<T, Maybe<R>>()
package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Single

abstract class SingleUseCase<in T, R> : BaseUseCase<T, Single<R>>()
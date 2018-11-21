package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Flowable

abstract class FlowableUseCase<in T, R> : BaseUseCase<T, Flowable<R>>()
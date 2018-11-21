package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Observable

abstract class ObservableUseCase<in T, R> : BaseUseCase<T, Observable<R>>()
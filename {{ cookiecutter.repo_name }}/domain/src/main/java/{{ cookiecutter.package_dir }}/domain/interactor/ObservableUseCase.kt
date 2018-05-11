package {{ cookiecutter.package_name }}.domain.interactor

import io.reactivex.Observable

abstract class ObservableUseCase<in T, R> : UseCase<T, Observable<R>>
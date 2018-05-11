package {{ cookiecutter.package_name }}.domain.interactor

interface UseCase<in T, out R> {
    fun execute(params: T? = null): R
}
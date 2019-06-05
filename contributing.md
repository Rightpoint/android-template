### Opening Project
1. Clone project.
2. Open Android Studio.
3. On the welcome screen in Android Studio click the `Open an existing Android Studio project` option and point it to the cloned repo.

Note: Code completion and other IDE sugar will not be functional because this is not a recognized project format.

### Testing Changes
1. Make your changes to the cookie cutter project.
2. Use [these instructions](https://github.com/Rightpoint/android-template#usage) to generate a project based on your changes.

Note: Be sure to use the cookiecutter namespace e.g. `{{ cookiecutter.package_name }}` to make generated files compile properly. 

### Notable Files
* [Pre Project Generation Logic](./hooks/pre_gen_project.py)
* [Post Project Generation Logic](./hooks/post_gen_project.sh)

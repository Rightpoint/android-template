# Android template
[![CircleCI](https://circleci.com/gh/Raizlabs/android-template.svg?style=svg&circle-token=963d814d921ee2f1f3c00d9079b362c94ac257a9)](https://circleci.com/gh/Raizlabs/android-template)
![Android](https://img.shields.io/badge/platform-android-green.svg)

A template for new Android projects at Raizlabs using Clean Architecture.

Inspired by [thoughtbot]/[android-template]

[thoughtbot]: https://thoughtbot.com/
[android-template]: https://github.com/thoughtbot/android-template
### Sections
* [Contributing](#contributing)
* [Usage](#usage)
* [Post Generation](#post-generation)

## Contributing
[Submit](https://github.com/Raizlabs/android-template/issues) an issue. If it is agreed the change needs to be made, [submit](https://github.com/Raizlabs/android-template/pulls) a pull request.

## Usage
1. [Install cookiecutter:](http://cookiecutter.readthedocs.io/en/latest/installation.html)
    * Mac OS: `brew install cookiecutter`
    * Debian/Ubuntu: `sudo apt-get install cookiecutter`
2. [Run cookiecutter against the template:](http://cookiecutter.readthedocs.io/en/latest/usage.html)
    * Against GitHub repo: `cookiecutter gh:raizlabs/android-template`
      * Specify a branch: `cookiecutter git@github.com:Raizlabs/android-template.git --checkout {name_of_branch}`
    * Local copy: `cookiecutter {path/to/android_template_project}`
3. Configure the project properties in the prompt.
4. Delete anything that is not of interest to your project.

## Post Generation
There are a number things that you still need to take care of to get your newly generated project up and running:
1. Enter `./gradlew configureGitHooks` into the terminal to take advantage of the pre-defined git hooks.
2. Run Gradle Sync in Android Studio to make sure you can build the project.
3. Generate 3 keystores for your project:
    * Generate a keystore for the develop, sprint and beta tracks
    * Make sure to add the actual keystore files to the repository
    * **DO NOT SAVE THE KEYSTORE CREDENTIALS TO THE REPO, USE 1PASSWORD!**
    * Utilize the same credentials for all 3 keystores to reduce complexity
    * Try to follow the convention of app name and build flavor for the alias:
        * For example: `doormanDevelop`, `doormanSprint` and `doormanBeta`
    * Update the `app/build.gradle` file to reflect these keystore values
4. Set your project up on CircleCI
5. Add the following environment variables to CircleCI **(A note on the following environment variables: they are prefixed with `ORG_GRADLE_PROJECT_` so they can be accessed within our Gradle scripts as project properties. This makes it easier for us to fake them outside of a CI environment.)**
    * `ORG_GRADLE_PROJECT_HOCKEYAPP_TOKEN` set to Raizlabs' HockeyApp token
    * The IDs for each of the tracks being deployed to HockeyApp:
        * `ORG_GRADLE_PROJECT_HOCKEYAPP_ID_DEVELOP` set to the develop track's HockeyApp ID
        * `ORG_GRADLE_PROJECT_HOCKEYAPP_ID_SPRINT` set to the sprint track's HockeyApp ID
        * Beta is optional*
    * `ORG_GRADLE_PROJECT_KEY_PASSWORD` set to the keystores' key password
    * `ORG_GRADLE_PROJECT_STORE_PASSWORD` set to the keystores' store password
    * Any keys that we don't want living in the repo

### How to deal with post-generation build woes
1. If you decided to launch Android Studio simply press the `Gradle Sync` button to generate a `local.properties` file.
    ![Android Studio Toolbar](documentation/studio_toolbar.png)
    
    Android Studio 3.1 and higher the option was moved into the File menu
    ![Android Studio File Menu](documentation/studio_file_menu.png)
2. If you decided not to launch Android Studio you need to make sure various environment variables are set before you can run any Gradle scripts:
    * You can set the following environment variables with the `export` command in the terminal
        * `ANDROID_HOME`=`/Users/{your_user}/Library/Android/sdk`
        * `JAVA_HOME`=`/Applications/Android\ Studio.app/Contents/jre/jdk/Contents/Home/` _(This only needs to be set if you have multiple versions of Java on your machine.)_

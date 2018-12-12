#!/bin/bash

initialize_git() {
    git init
    git add -A
}

install_or_update_ktlint() {
    # Check for Homebrew, if it's not installed then install it
    which -s brew
    if [[ $? != 0 ]] ; then
        install_brew_variant
        brew install shyiko/ktlint/ktlint
    else
        brew update
    fi
}

install_brew_variant() {
    if [[ "$OSTYPE" == "linux-gnu" ]]; then
        install_linuxbrew
    elif [[ "$OSTYPE" == "darwin"* ]]; then
        install_homebrew
    else
        echo ERROR: Unsupported operating system
        exit 1
    fi
}

install_linuxbrew() {
    sh -c "$(curl -fsSL https://raw.githubusercontent.com/Linuxbrew/install/master/install.sh)"
    test -d ~/.linuxbrew && eval $(~/.linuxbrew/bin/brew shellenv)
    test -d /home/linuxbrew/.linuxbrew && eval $(/home/linuxbrew/.linuxbrew/bin/brew shellenv)
    test -r ~/.bash_profile && echo "eval \$($(brew --prefix)/bin/brew shellenv)" >>~/.bash_profile
    echo "eval \$($(brew --prefix)/bin/brew shellenv)" >>~/.profile
}

install_homebrew() {
    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
}

apply_ktlint_to_project() {
    if [[ ! -d .idea ]]; then
        mkdir .idea
    fi
    printf 'y' | ktlint --apply-to-idea-project --android
    git add -A
}

update_project_permissions() {
    cd ..
    chmod -R 777 "{{ cookiecutter.repo_name }}"
}

attempt_to_launch_studio() {
    if [[ -z ${CI+x} ]]; then
        check_for_launch_flag
    else
        echo "Skipping the launching of Android Studio because we're building on CI..."
    fi
}

check_for_launch_flag() {
    if [[ "{{ cookiecutter.launch_studio }}" = true ]]; then
        launch_studio
    else
        echo "Skipping the launching of Android Studio..."
    fi
}

launch_studio() {
    if [[ "$OSTYPE" == "darwin"* ]]; then
        /Applications/Android\ Studio.app/Contents/MacOS/studio $PWD/"{{ cookiecutter.repo_name }}"
        echo "Android Studio should now be running, have fun with your new project!"
    else
        echo "Unsupported operating system: skipping the launching of Android Studio..."
    fi
}

initialize_git
install_or_update_ktlint
apply_ktlint_to_project
update_project_permissions
attempt_to_launch_studio
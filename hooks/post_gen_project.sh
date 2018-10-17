#!/bin/sh

git init

git add -A

cd ..
chmod -R 777 "{{ cookiecutter.repo_name }}"

if [ -z ${CI+x} ]; then
    if [ "{{ cookiecutter.launch_studio }}" = true ]; then
        /Applications/Android\ Studio.app/Contents/MacOS/studio $PWD/"{{ cookiecutter.repo_name }}"
        echo "Android Studio should now be running, have fun with your new project!"
    else
        echo "Skip launching of Android Studio..."
    fi
else
    echo "Skip launching of Android Studio because we're building on CI..."
fi
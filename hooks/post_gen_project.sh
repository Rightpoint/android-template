#!/bin/sh

git init

git add -A

cd ..
chmod -R 777 "{{ cookiecutter.repo_name }}"

if [ "{{ cookiecutter.caching_library }}" = Room ]; then
    rm -r "{{ cookiecutter.repo_name }}/cache-realm"
elif [ "{{ cookiecutter.caching_library }}" = Realm ]; then
    rm -r "{{ cookiecutter.repo_name }}/cache-room"
else
    echo "Cannot determine the caching library..."
fi

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
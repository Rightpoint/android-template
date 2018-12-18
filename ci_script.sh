#!/bin/bash

[[ -z "$CIRCLE_BRANCH" ]] && branch='develop' || branch="$CIRCLE_BRANCH"

echo ${branch}

cookiecutter git@github.com:Raizlabs/android-template.git --checkout ${branch} --no-input

cd project-name-android

./gradlew lint:test assembleDebug
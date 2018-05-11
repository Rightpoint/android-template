#!/usr/bin/env bash

cp -a ../android-template/. "${TMPDIR}android-template/"

cd $TMPDIR

cookiecutter "${TMPDIR}android-template/" --no-input
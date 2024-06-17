#!/usr/bin/env groovy

def call () {
    echo "Building Jar File for branch $BRANCH_NAME"
    sh 'mvn package'
}
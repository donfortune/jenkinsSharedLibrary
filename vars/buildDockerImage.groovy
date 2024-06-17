#!/usr/bin/env groovy

def call (String ImageName) {  
    echo "Building Jar File"
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PWD', usernameVariable: 'USERNAME')]) {
        
        sh "docker build -t $ImageName ."
        sh "docker login -u $USERNAME -p $PWD"
        sh "docker push $ImageName"
    }
}
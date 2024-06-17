#!/usr/bin/env groovy
package com.examples

class Docker implements Serializable {
    def script 

    Docker(script) {
        this.script = script
    }


    def buildDockerImage(String ImageName){  
        script.echo "Building Jar File"
        script.withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PWD', usernameVariable: 'USERNAME')]) {
            
            script.sh "docker build -t $ImageName ."
            script.sh "docker login -u $script.USERNAME -p $scriptt.PWD"
            script.sh "docker push $ImageName"
        }
    }
}
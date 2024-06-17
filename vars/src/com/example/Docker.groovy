#!/usr/bin/env groovy
package com/example

class Docker implements Serializable {
    def script 

    Docker(script) {
        this.script = script
    }


    def buildDockerImage(String ImageName){  
        script.echo "Building Jar File"
        script.sh "docker build -t $ImageName ."
            
        }

    
    def dockerLogin(){
        script.withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PWD', usernameVariable: 'USERNAME')]) {
            script.sh "docker login -u $script.USERNAME -p $script.PWD"
        }
    }

    def dockerPush(String ImageName){
        script.sh "docker push $ImageName"
    }

}

    

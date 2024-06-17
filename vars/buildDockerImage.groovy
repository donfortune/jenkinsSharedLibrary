#!/usr/bin/env groovy
import com.examples.Docker

def call (String ImageName) {  
    return new Docker(this).buildDockerImage(ImageName)
}
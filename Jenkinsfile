@Library('myClearAir') _
// 'myClearAir' is the name of my global library that I've configured on my 
// Jenkins Instance under 
// "Manage Jenkins" >> "Configure System" >> "Global Pipeline Libraries"

pipeline {
  // If using standard master/agent Jenkins setup
  // agent any 
  agent {
    // Spin up a container inside of k8s to use as agent
    kubernetes {
      containerTemplate {
        name 'my-groovy'
        image 'groovy'
      }
    }
  }
  stages {
    stage('JGL Shared Methods') {
      steps {
        blueSky("Freedom")  //=> "Hello Freedom"
        blueSky("World")    //=> "Hello World"
      }
    }
    stage('JGL Named Functions') {
      steps {
        script {
          // Named methods need to be in a script{} block or Jenkins will throw 
          // and error. Boo! 👎
          blueSky.flyAway() //=> "Fly Away Birdie"
        }
      }
    }
  }
}
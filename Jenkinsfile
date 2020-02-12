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
    stage('Clean Air Test') {
      steps {
        blueSky("Freedom")  //=> "Hello Freedom"
        blueSky("World")    //=> "Hello World"
      }
    }
  }
}
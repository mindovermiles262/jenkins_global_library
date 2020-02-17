#!/usr/bin/env groovy

def configGlobal(String envName = 'test',
                 String namespace = 'default',
                 String yamlFile = 'dataeng-env.yml') {
  /*
  Use this method to set global ENV Variables

  TODO: Write this Method.

  Tried to use a similar method to configLocal() but could not set global
  ENV Variables from inside this method. Should look into exporting an 
  'environment {}' block and loading that from the Jenkinsfile

  */
}

def configLocal(String envName = 'test',
                String namespace = 'default',
                String yamlFile = 'dataeng-props.yml') {
  def propsFile = libraryResource yamlFile // loads from ../resources directory
  def config = readYaml text: propsFile
  def props = [:]
  config['environments'][envName][namespace].each {
    props[it.key] = it.value
  }
  return props
}


def verifyBranch(String branchName,
                 String regexPattern = "(^master\$|^feature/.*)") {
  if(branchName ==~ /${regexPattern}/) {
    println "Branch ${branchName} is valid"
  } else {
    println "[FAILED] Branch ${branchName} is INVALID"
    println "REGEX: ${regexPattern}"
    // error('[FAIL] Branch is Invalid')
  }
}

def verifyBranchName(String regexPattern = "(^master\$|^feature/.*|^develop\$)") {
  if(env.BRANCH_NAME ==~ /${regexPattern}/) {
    println "Branch ${env.BRANCH_NAME} is valid"
  } else {
    error("[FAILED] Branch ${env.BRANCH_NAME} is INVALID")
  }
}

def unitTest(String unitTestLanguage = "python", 
             String unitTestContainer = "unit-test-python") {
  switch(unitTestLanguage){
  case("python"):
    pipeline {
      container(testContainer) {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']],
            userRemoteConfigs: [[url: env.UNITTEST_GIT_URL]]])
        if (env.UNITTEST_MAKEFILE_PATH) {
          echo "Using Makefile specified: ${env.UNITTEST_MAKEFILE_PATH}"
          sh "make -f ${env.UNITTEST_MAKEFILE_PATH} test"
        } else {
          echo "No Makefile Specified. Using default"
          sh 'ls -l'
          sh "pwd"
          sh "make test"
        }
      }
    }
  default:
    error("[!] Unit Testing Language not supported.")
  }
}

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

// def overwriteDefaultMap(Map dflt, Map args) {
//   // do something
//   returnMap = args.each{ entry -> dflt << [entry.key:entry.value] }
// }

// Runs 'make test' on specified git repository. Defaults to a python testing
// environment.
def unitTest(String unitTestGitUrl,
             Map passed_args = [:]) {
  use_args = [
    unitTestGitBranch: "*/master",
    unitTestMakefile: "Makefile",
    unitTestLanguage: "python",
    unitTestContainer: "unit-test-python"
  ]
  passed_args.each{entry -> use_args << [$entry.key:$entry.value]}
  // switch(unitTestLanguage){
  // case("python"):
  //   pipeline {
  //     container(unitTestContainer) {
  //       checkout([$class: 'GitSCM', branches: [[name: unitTestGitBranch]],
  //           userRemoteConfigs: [[url: unitTestGitUrl]]])
  //       sh "make -f ${unitTestMakefile} test"
  //     }
  //   }
  // default:
  //   error("[!] Unit Testing Language not supported.")
  // }
  use_args.each{entry -> println "$entry.key: $entry.value"}
}

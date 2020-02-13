#!/usr/bin/env groovy

def configGlobal(String envName = 'test', String namespace = 'default', String yamlFile = 'dataeng-env.yml') {
  /*
  Use this method to set global ENV Variables

  TODO: Write this Method.

  Tried to use a similar method to configLocal() but could not set global
  ENV Variables from inside this method. Should look into exporting an 
  'environment {}' block and loading that from the Jenkinsfile

  */
}

def configLocal(String envName = 'test', String namespace = 'default', String yamlFile = 'dataeng-props.yml') {
  def propsFile = libraryResource yamlFile // loads from ../resources directory
  def config = readYaml text: propsFile
  def props = [:]
  config['environments'][envName][namespace].each {
    props[it.key] = it.value
  }
  return props
}


def verifyBranch(String branchName) {
  if(branchName ==~ /(^master$|^feature\/.*)/) {
    println "Branch is valid"
  } else {
    println "Branch is INVALID"
    error('[FAIL] Branch is Invalid')
  }
}


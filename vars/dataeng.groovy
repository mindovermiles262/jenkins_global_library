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
  log.info("configLocal() envName is ${envName}")
  log.info("configLocal() namespace is ${namespace}")
  log.info("configLocal() yamlFile is ${yamlFile}")
  def propsFile = libraryResource yamlFile // loads from ../resources directory
  def config = readYaml text: propsFile
  def props = [:]
  config['environments'][namespace][envName].each {
    props[it.key] = it.value
  }
  return props
}


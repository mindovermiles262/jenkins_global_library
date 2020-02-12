#!/usr/bin/env groovy

def configGlobal(String envName = 'test', String yamlFile = 'dataeng-env.yml') {
  // Use this method to set global ENV Variables

  // def envFile = libraryResource yamlFile
  // def config = readYaml text: envFile
  // config['environments'][envName].each{ 
  //   sh "export ${it.key}='${it.value}'"
  // }
}

def configLocal(String envName = 'test', String yamlFile = 'dataeng-props.yml') {
  def propsFile = libraryResource yamlFile // Looks in resources directory
  def config = readYaml text: propsFile
  def props = [:]
  config['environments'][envName].each {
    sh "echo ${it.key} is ${it.value}"
    props[it.key] = it.value
  }
}


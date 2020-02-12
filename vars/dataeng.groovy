#!/usr/bin/env groovy

def configGlobal(String envName = 'test', String yamlFile = 'global-env-config.yml') {
  def envFile = libraryResource yamlFile
  def config = readYaml text: envFile
  config['environments'][envName].each{ 
  println "${it.key} = ${it.value}"
  sh "export ${it.key}=${it.value}"
  }
}


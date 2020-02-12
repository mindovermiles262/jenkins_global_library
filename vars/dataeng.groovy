#!/usr/bin/env groovy

def configGlobal(String envName = 'test', String yamlFile = 'global-env-config.yml') {
  def envFile = libraryResource yamlFile
  def config = readYaml text: envFile
  echo "envName: ${envName}"
  config['environments'][envName].each{
    println "$it.key = $it.value" 
  }
}


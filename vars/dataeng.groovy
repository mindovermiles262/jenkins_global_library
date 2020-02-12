#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  // Loads env vars from resources/
  def envFile = libraryResource 'global-env-config.yml'
  def config = readYaml text: envFile
  config.environments.${envName}.each{ println "Key: $it.key = Value: $it.value" }
}


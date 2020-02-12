#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  def envFile = libraryResource 'global-env-config.yml'
  def config = readYaml text: envFile
  def envMap = config.environments.${envName}
  envMap.each{ println "Key: $it.key = Value: $it.value" }
}


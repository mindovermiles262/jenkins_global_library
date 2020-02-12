#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  def envFile = libraryResource 'global-env-config.yml'
  def config = readYaml text: envFile
  echo "Config:"
  echo config
  echo "END"
  def envObj = config.environments.envName
  echo "envObj"
  echo envObj
  echo "END"
}


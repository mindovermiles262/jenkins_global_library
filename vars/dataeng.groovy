#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  def envFile = libraryResource 'env-branch.yml'
  def config = readYaml text: envFile
  echo "Config:"
  echo config
  def envObj = config.environments.find{it.name == envName}
  echo "envObj"
  echo envObj
}


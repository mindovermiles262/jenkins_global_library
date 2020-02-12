#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  def envFile = libraryResource 'global-env-config.yml'
  def config = readYaml text: envFile
  echo "Config:"
  echo config.environments.test
  echo "END"
}


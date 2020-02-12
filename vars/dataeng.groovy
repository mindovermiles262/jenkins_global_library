#!/usr/bin/env groovy

def configGlobal(String envName = 'test') {
  def envFile = libraryResource 'global-env-config.yml'
  def config = readYaml text: envFile
  def thisEnv = config.environments.${envName}
  echo thisEnv.var1
}


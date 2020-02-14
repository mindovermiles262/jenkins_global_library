#!/usr/bin/env groovy

/*
This fine, dataeng.groovy is a shared helper library for Jenkins. Inside contains
all of the helper functions for simplifying DataEngineering's pipelines.

You can call a function from this library by simply calling dataeng.methodName()
inside of the pipeline fine.
*/

// Checks if branch name is 'master' or 'feature/*'. Fails if not.
def verifyBranch(regexPattern = "(^master$|^feature\/.*)") {
  if(branchName ==~ /${regexPattern}/ {
    println "Branch name is valid"
  } else {
    error('[FAIL] Branch is Invalid')
  }
}

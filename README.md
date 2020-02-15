# Jenkins Global Library

A collection of useful libraries for Jenkins.

## Gotcha's

* Jenkins Plugin [Pipeline Utility Steps](https://plugins.jenkins.io/pipeline-utility-steps/) needs to be installed for `readYaml` function to work in `vars/dataeng.groovy`

## Loading this Library

You can add this library to your Jenkins instance by logging into your Jenkins admin portal. Then do the following:

* Choose `Manage Jenkins` > `Configure System`
* Scroll down to `Global Pipeline Libraries` and choose `Add`
* Enter the following information:
  * Name => Name the library whatever you want to. You'll use this name to call the library functions later.
  * Default Version => `master`
* Select `Modern SCM` and use this repo's URL:
  * Project Repository => `https://github.com/mindovermiles262/jenkins_global_library`

## Calling Library Methods

Included in this repo is a `Jenkinsfile` that will run the `blueSky` shared library. In short,

```
@Library('name-of-global-library-imported-above')

pipeline {
  stages {
    stage('Use Global Library') {
      steps {
        blueSky("Freedom")
      }
    }
  }
}
```

By default, unnamed imports will look for a `call()` method inside the shared library groovy file and execute that. Otherwise you can choose a named method to execute in the form `blueSky.flyAway()`

## Helpful Links

* Jenkins Shared Library Documentation: 
https://jenkins.io/doc/book/pipeline/shared-libraries/

* Example Shared Library Tutorial: 
https://tomd.xyz/jenkins-shared-library/

* Using `container` directives in a pipeline (w/ examples):
https://akomljen.com/set-up-a-jenkins-ci-cd-pipeline-with-kubernetes/

* Kubernetes Plugin for Jenkins:
https://github.com/jenkinsci/kubernetes-plugin

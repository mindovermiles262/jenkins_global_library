# DataEng Shared Library for Jenkins

Various functions to assist Data Engineering Jenkins Pipelines

## Methods

* `configLocal()` => Set local parameters
* `verifyBranch()` => Verify that working branch follows git-flow branch patterns
* `configGlobal()`=> Set global environment variables
* `unitTest()` => Run unit testing across git branch

## unitTest()

Default Action: Runs `make test` inside dataeng-image-base container.

### Usage

`unitTest([LANGUAGE], [CONTAINER])`

__REQUIRED__
* `env.UNITTEST_GIT_URL` => URL to the repository you want to test

__OPTIONAL__
* `CONTAINER` => Specify the container to use to test the codebase. These containers should contain everything to run the tests.
* `LANGUAGE` => Specify which language you want to test.  Language testing specifics are configured inside `dataeng.groovy` switch statement.
* `env.UNITTEST_MAKEFILE_PATH` => Path within the repository to the makefile which contains testing functions for `make test`

__EXAMPLE__
```
// Jenkinsfile
agent {
  kubernetes {
    containerTemplate {
      image 'ruby:2.6.3'
      name 'my-ruby-unittest-container'
      ttyEnabled true
      command 'cat'
    }
  }
}

//--- snip ---//

stage("Unit Testing") {
  steps {
    script {
      withEnv([
          'TESTING_GIT_URL=http://github.com/user/ruby-repo', 
          'TESTING_MAKEFILE_PATH=testing/Makefile']) {
        dataeng.unitTest("ruby", "my-ruby-unitest-container")
      }
    }
  }
}
```

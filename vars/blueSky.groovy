#!/usr/bin/env groovy

/*
Clean Air Testing

Checks that you've configured your Jenkins instance to load global libraries
 from an outside repository. Use the included Jenkinsfile to test. Outputs 
 "Hello Groovy" if everything is working and there is clear air to continue
*/

def call(String noun = 'Groovy') {
  echo "Hello ${noun}"
}

def flyAway() {
  echo "Fly Away Birdie"
}

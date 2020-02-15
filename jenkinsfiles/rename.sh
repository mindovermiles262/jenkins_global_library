#!/bin/bash
 
for i in Jenkinsfile-*; do
  NF=$(echo $i | sed "s/Jenkinsfile-//")
  mv "$i" "$NF"
done

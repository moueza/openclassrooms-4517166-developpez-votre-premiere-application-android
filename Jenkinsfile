def gv
pipeline {
  agent any
  tools{
    #maven Maven
  }
  stages{
    stage("init"){
      steps {
        script{
          gv = load "script.groovy"
        }
      }
    }
    stage("build"){
      steps {
        gv.buildApp()
      }
    }
    stage("test"){
      steps {
        echo 'testing the app...'
      }
    }
    stage("deploy"){
      steps {
        echo 'deploying the app...'
      }
    }
  }
}

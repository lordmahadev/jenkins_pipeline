//This is the comment

/*
Multi line comment
*/

//agent
//any: we will execute the pipeline or stage with any avy available agent
pipeline{//top level field
  agent any
  stages {
    stage ('FirstStage') {  //Name: Can be userfreinly name but needs to be specific for task performing
     steps {
        echo "Welcome to First Pipeline"
     }

    }
  }

}

//2 *******************

pipeline{
    agent {
        label 'mvn-slave'
    }
    stages {
         stage ('labelstage'){
            steps{
                //this should give private ip of my mvn-slave
            sh 'hostname -i'

            }
            
         }
    }
}

//node************

pipeline {
    agent none
    stages {
        stage ("Build") {

            agent {
                node {
                    label 'mvn-slave'
                customWorkspace "/home/amani/customamani"

                }
            }
            steps {

                echo "Hello! executing node in agent"
                sh "hostname -i"
                sh "cat imp.txt"
            }
        }
    }
}
 

 //

pipeline {
    agent none
    stages {
        stage ("Build") {

            agent {
                node {
                    label 'mvn-slave'
                customWorkspace "/home/amani/customamani"

                }
            }
            steps {

                echo "Hello! executing node in agent"
                sh "hostname -i"
                sh "cat imp.txt"
                git branch: 'main', url: 'https://github.com/spring-projects/spring-petclinic.git'
            }
        }
    }
}
 

          
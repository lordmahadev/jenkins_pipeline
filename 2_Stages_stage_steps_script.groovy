pipeline {
    agent any 
    stages {
        stage ("hello"){
            steps {
                echo "hello"
            }
        }
        stage ('Scripted stage'){
            steps {
                script {
                    def course = "k8s"
                if (course == "k8s") {
                    println ("Thanks for enrolling ${course}")
                }
                else
                println("Do enroll")

                }
                
            }
        }
    }

}
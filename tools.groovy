//we can use tools section to auto install packages or define path of the package
//we can add tools section under pipeline >stages>stage 
//or 
// we can add pipeline>tool
// pipeline to use tools section under pipeline and stage

pipeline{
    agent any
    tools{
        maven 'maven-slave'
    }
    stages{
        stage('maven stage 1'){
            tools{
                maven 'maven-new'
                jdk 'JDK-17'

            }
            steps{
                echo 'maven version'
                sh 'man --version'
                sh 'java -version'
            }
        }

    }
}
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo '*** building the application ***'
            }
        }
        stage('Sonar') {
            steps {
                echo '*** running Sonar analysis ***'
            }
        }
        stage('Docker Build') {
            steps {
                echo '*** Docker build stage ***'
            }
        }
        stage('Docker Push') {
            steps {
                echo '*** entered into the Docker push stage ***'
            }
        }
        stage('Dev') {
            steps {
                echo '*** deployed into the Dev environment ***'
            }
        }
        stage('Test') {
            steps {
                echo '*** deployed into the Test environment ***'
            }
        }
        stage('Stage') {
            steps {
                echo '*** deployed into the Stage environment ***'
            }
        }
        stage('Prod') {
            steps {
                script {
                    // Input step with timeout and submitter
                    timeout(time: 10, unit: 'SECONDS') {
                        input message: 'Ready to deploy to Prod?', 
                              ok: 'Deploy', 
                              submitter: 'sunil' // AD or Jenkins database username
                    }
                    echo '*** deployed into the Prod environment ***'
                }
            }
        }
    }
}

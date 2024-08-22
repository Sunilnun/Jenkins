// tag based deployment

pipeline
{
    agent any
    stages{
        stage('Build'){
            steps{
                echo '*** building the application **'
            }
        }
        stage('sonar'){
            steps{
                echo '*** building the sonar ***'
            }
        }
        stage('docker build'){
           steps{
            echo '** docker build stage ***'

            }

        }
        stage('docker push'){
            steps{
                echo '*** entered into the docker push stage ***'
            }
        }
         stage('dev'){
            steps{
                echo '*** deployed into the dev environment ***'
            }
        }
         stage('test'){
            steps{
                echo '*** deployed into the test environment ***'
            }
        }
         stage('stage'){
          
            steps{
                echo '*** deployed into the stage environment ***'
            }
        }
        stage('PROD'){
         
         input{
            message 'redy to deploy in prod'
            ok 'yes'
            submitter 'sunil' //ad or input data usename need to be present
         }
            steps{
                echo '*** deployed into the prod environment ***'
            }
        }

    }
}


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
            when{
                branch 'release/*'
            }
            steps{
                echo '*** deployed into the stage environment ***'
            }
        }
        stage('PROD'){
            when{
                //our application should deploy to prod only if the app is going through tag
                //vx.xx.x ==> v1.2.3
                tag pattern: "v\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}", comparator: "REGEXP"
            }
            steps{
                echo '*** deployed into the prod environment ***'
            }
        }

    }
}
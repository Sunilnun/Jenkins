pipeline{
    agent any
    stages{
        stage('this is the build stage'){
            steps{
                echo 'building the application'
                sleep 20

            }
        }
        stage('building the parallel stage'){
            parallel{
                stage('stage 1'){
                    steps{
                        echo 'building the stage 1'
                        sleep 10
                    }
                }
                stage('stage 2 building'){
                    steps{
                        echo 'building the stage2'
                        sleep 20
                    }
                }
                stage('stage 3 building'){
                    steps{
                    echo 'building the stage 3'
                    sleep 30

                    }
                    
                }
            }
        }
        stage('this is the deploy stage'){
           steps{
            echo 'building the deployment block'
            sleep 60


           } 
        }
    }
}
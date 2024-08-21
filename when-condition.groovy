//when: atleast one condition must be specified
// https://www.jenkins.io/doc/book/pipeline/syntax/#when
// if more than one condition is specified , all conditions must return true for the stage to be executed.
pipeline{
    agent any
    environment{
        DEPLOY_TO = 'PROD'
    }
    stages{
        stage('when condition block'){
            when{
                environment name: 'DEPLOY_TO' , value: 'PROD'              
            }
            steps{
                echo 'deploy to the stage when condition is success'
            }
        }
    }
}
// Multiple when conditions 

pipeline{
    agent any
    environment{
        DEPLOY_TO = 'PROD'
        DEPLOYING_TO = 'STAGE'
    }
    stages{
        stage('when condition block'){
            when{
                environment name: 'DEPLOY_TO' , value: 'PROD'
                environment name: 'DEPLOYING_TO' , value: 'STAGE'
            }
            steps{
                echo 'deploy to the stage when condition is success'
            }
        }
    }
}

// default env defined by the jenkins for MBP
//this will executes only with the MBP
pipeline{
    agent any
    stages{
        stage('when blcok with defaults'){
            when{
                expression { BRANCH_NAME ==~ /(docker|kubernetes)/}
            }
            steps{
                echo 'deploying to kubernetes'
            }
        }
    }
}

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
//anyOf (hear O is capital letter) if we keep this any one condition 
//should met while executing the when condition

pipeline{
    agent any
    environment{
        DEPLOY_TO = 'Production'
    }
    stages{
        stage('any of stage'){
            when{
                anyOf{
                    expression { BRANCH_NAME == ~ /(docker|kubernetes)/}
                    environment name: 'DEPLOY_TO', value: 'Production'
                  // hear it will get succed because environment is getting matched
                }

            }
            steps{
                echo 'when stage met all the cretatia'
            }
        }
    }
}

//allOf (hear O is capital letter) if we keep this all conditions should meet
pipeline{
    agent any
    environment{
        DEPLOY_TO = 'Production'
    }
    stages{
        stage('any of stage'){
            when{
                allOf{
                    expression { BRANCH_NAME == ~ /(docker|kubernetes)/}
                    environment name: 'DEPLOY_TO', value: 'Production'
                  
                }
            }
            steps{
                echo 'when stage met all the cretatia'
            }
        }
    }
}

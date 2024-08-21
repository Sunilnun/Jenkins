//parameters will allow you to pass the dynamic values during the run time

pipeline {
    agent any
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }
    stages{
        stage('parameter example'){
            steps{
                echo "welcome ${params.PERSON}" //$params key

            }            
            

        }
    }
}

// example with more elabration

pipeline{
    agent any
    parameters{
        string (name: 'change ticket number', defaultValue: 'ITCHG12345', description: 'enter the change request number')
        text (name: 'which environment', defaultValue: 'dev', description: 'which environment you are deploying')
        boolparam (name: 'is sre approved', defaultValue: 'true' description: 'is approval taken from the SRE')
        choice (choices: 'regular/hotfix/main/feature', name: 'Regular', description: 'what release is this')
        password (name: 'my password', defaultValue:'' , description: 'enter your password')
        credentials (name: 'my creds', description: 'my docker credentials', required: 'true')    
    }
    stages{
        stage('parameters stage'){
            steps{
                echo "your change ticket number is ${params.change ticket number}"
                echo "you are deploying to ${params.which environment}"
                echo "you are deploying from ${params.Regular} branch"
                echo "your password is ${params.my password}"
                echo "selected credentials are ${params.my creds}"
            }
        }
    }
}
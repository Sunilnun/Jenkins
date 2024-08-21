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
        string (name: 'change_ticket_number', defaultValue: 'ITCHG12345', description: 'enter the change request number')
        text (name: 'which_environment', defaultValue: 'dev', description: 'which environment you are deploying')
        choice (choices: 'regular\nhotfix\nmain\nfeature', name: 'Regular', description: 'what release is this')
        password (name: 'my_password', defaultValue:'' , description: 'enter your password')
        credentials (name: 'my_creds', description: 'my docker credentials', required: 'true')    
    }
    stages{
        stage('parameters stage'){
            steps{
                echo "your change ticket number is ${params.change_ticket_number}"
                echo "you are deploying to ${params.which_environment}"
                echo "you are deploying from ${params.Regular} branch"
                echo "your password is ${params.my_password}"
                echo "selected credentials are ${params.my_creds}"
            }
        }
    }
}
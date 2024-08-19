// this is comments in jenkins
//this is the agent example
//agane any means it will run in the any of the avaliable agent
pipeline{
agent any
stages{
    stage('this is the first stage'){
        steps{
            echo 'hi from the frist stage'
        }

    }
    stage('this is the second stage'){
        steps{
            echo 'this is from the second stage'

        }
    }
}

}

//none: if we declare agent none at the top level of the pipeline, no global agent will be allocated
//we need to specify agent in each and every stage.
//label: A string which inform jenkins to run those job/stage on a particular agent.
pipeline{
    agent{
        label 'java-agent'
    }
    stages{
        stage('we are running on particular agent as per our requirement'){
            steps{
                echo 'hi from the java worker node'
            }
        }
    }
}

pipeline{
    agent none
    stages{
        stage('hi from the java agent') {
            agent{
                label 'java-agent'
            }
            steps{
                echo 'this is from the java agent'

            }
        }
        stage('hi from node agent') {
            agent{
                label 'node-slave'
            }
            steps{
                echo 'this is from the node slave'
            }
        }
        
    }
}



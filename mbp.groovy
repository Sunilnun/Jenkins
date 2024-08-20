pipeline{
    agent any
    stages{
        stage('this is first mbp stage'){
            steps{
                echo 'welcome to the mbp stage'

            }           
        }
    }
}
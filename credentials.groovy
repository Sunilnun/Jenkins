//credentials are most frequently used
//for example like , ssh keys, nexus/jfrog, sonar tokens, ssh credentials, and many more
pipeline{
    agent any
    stages{
        stage('this is for the crdentials stage'){
            environment{
                GITHUB_CREDENTIALS = credentials('jenkins-slave1-ssh-username')
            }
            steps('this is to print the credentials part'){
                echo "github_credentials are: ${GITHUB_CREDENTIALS} "
                echo "github user name is: ${GITHUB_CREDENTIALS_USR}"
                echo "github password is ${GITHUB_CREDENTIALS_PSW}"
            }
        }
    }
}
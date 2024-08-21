//environment can be declared at the stage level and at the pipeline level

pipeline{
    agent any
    environment{
        course = "docker and kubernetes"
        name = "sunil"
    }
    stages{
        stage('this is for the environment stage'){
            environment{
                gcp = "gcp"
            }
            steps{
                echo "thanks for learning ${course}"
                echo "you will start learning ${gcp} tomorrow"
                echo "you will get good job soon ${name}"

            }
        }
    }
}

//second example

pipeline{
    agent any
    environment{
        containers = "docker"
        cluster = "kubernetes"
    }
    stages{
        stage('this is define docker and kubernetes'){
            environment{
                integration = "jenkins"
            }
            steps{
                echo "${containers} it is build using the images"
                echo "${cluster} micro applications will be deployed hear"
                echo "${integration} is the tool used for continuous integration purpose"
            }
        }
        stage('this is the second stage'){
            steps{
                echo "${containers} it is build using the images"
                echo "${cluster} micro applications will be deployed hear"
                echo "${integration} is the tool used for continuous integration purpose"

            }
        }
    }
}

//presedence which environment variables will be picked
//environment value in the stage will be taking presedence instead of pipeline
pipeline{
    agent any
    environment{
        containers = "docker"
        cluster = "kubernetes"
        integration = "jenkins"
    }
    stages{
        stage('this is define docker and kubernetes'){
            environment{
                integration = "bamboo"
            }
            steps{
                echo "${containers} it is build using the images"
                echo "${cluster} micro applications will be deployed hear"
                echo "${integration} is the tool used for continuous integration purpose"
            }
        }
        stage('this is the second stage'){
            steps{
                echo "${containers} it is build using the images"
                echo "${cluster} micro applications will be deployed hear"
                echo "${integration} is the tool used for continuous integration purpose"

            }
        }
    }
}


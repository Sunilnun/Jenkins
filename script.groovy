pipeline{
    agent{
        label 'java-agent'
    }
    stages{
        stage('this stage is to build the statement'){
            steps{
                echo 'you are in build stage'
            }
            
        }

        stage('this stage is for the example of script'){
            steps{
                echo 'executing the script stage'
                //write some custom code
                script {
                    //define a variable
                   sh 'hostname -i'
                    def course = "k8sghjsef"
                    if (course == "k8s") {
                        println("thanks for enrolling into $course")
                    }
                    else
                    println ("do learn $course")
                
                }
            }
        }
    }
}


 
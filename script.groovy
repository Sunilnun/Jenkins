// examplefor the defining a variable
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
                    // to execute any linux  commands we will use the sh command
                   sh 'hostname -i'
                   //define a variable
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


// this is example for the sleep it is nothing but the normal sleep command in the linux.
//in jenkins we will use this command to sleep a particular block or stage to seelpfor some time
// and the start executing the other stage or block
pipeline{
    agent any
    stages{
        stage('this is the first stage'){
            steps{
                echo 'this step is to print the host name'
                script{
                    sh 'hostname -i'
                    sleep 10 //seconds
                }
            }
            
        }
        stage('this is the second stage'){
                steps('this stage is for defining a script given'){
                    script{
                        def name = "sunil"
                        if(name == "Sunil"){
                            println("$name he will live long life happly")
                        }
                        else{
                            println("$name he will live in good place and good vibe")
                        }
                    }
                }
            }
    }
}

//retry: this is used to retry a particular block multiple times
//timeout : this is used to enforce the time limit

pipeline{
    agent any
    stages{
        stage('this is the block to retry'){
            steps{
                echo "entering the retrt block"
                retry(3){
                    echo "welcome to retry block"
                    error "testing the retry block"
                }
                echo "successfully completed the retry block for 3 times"
            }
        }
    }
}

//timeout: we will use this if we want to a particular block to wait for particalur time onlt after
//that it will expire

pipeline{
    agent any
    stages{
        stage('sleeping stage'){ 
            steps{
                    timeout(time: 10 , unit: 'HOURS'){
                    echo"sleeping for 60 seconds"
                    sleep 60
                    //sunil approval
                }
                echo 'sleeping block completed'
            }        
        }
    }
}


 
pipeline {
    agent any
    stages {
        stage('Install Java 16') {
            steps {
                script {
                    def javaVersion = '16'
                    def installDir = "/usr/local/java/jdk-16"

                    // Download Java
                    sh """
                    wget https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html#license-lightbox
                    """

                    // Create installation directory
                    sh """
                    sudo mkdir -p ${installDir}
                    """

                    // Extract Java
                    sh """
                    sudo tar -xzf jdk-16.tar.gz -C ${installDir} --strip-components=1
                    """

                    // Set environment variables
                    sh """
                    echo "export JAVA_HOME=${installDir}" | sudo tee -a /etc/profile
                    echo "export PATH=\$JAVA_HOME/bin:\$PATH" | sudo tee -a /etc/profile
                    source /etc/profile
                    """
                }
            }
        }
        stage('Verify Java Installation') {
            steps {
                sh 'java -version'
                sh 'javac -version'
            }
        }
    stage ('SpecificStage') {
            tools {
                jdk 'JDK-17'
            }
            steps {
                echo "****** Maven version with my custom java at /opt******"
                sh "mvn --version"
            }
        }
    }
}


//code committed

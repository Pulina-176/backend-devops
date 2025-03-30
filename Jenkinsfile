pipeline {
    agent any

    environment {
        // Define environment variables here if needed
        ImageRegistry = "chamudim"
    }

    stages {

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'chamudi-dockerhub-pass', variable: 'chamudi-dockerhub-pass')]) {
                    script {
                        echo "Logging in to Docker Hub..."
                        bat """
                        docker login -u chamudim -p %chamudi-dockerhub-pass%
                        """
                    }
                }
            }
        }

        stage('Build Jar'){
            tools{
                maven 'Maven 3.9.9'
            }
            steps {
                script {
                    echo "Building Jar..."
                    bat """
                    mvn clean package -DskipTests
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image..."
                    bat """
                    docker build -t %ImageRegistry%/devops_api:latest .
                    """
                }
            }
        }

        stage('Push Docker Image to DockerHub') {
            steps {
                script {
                    echo "Pushing Docker image to Docker Hub..."
                    bat """
                    docker push %ImageRegistry%/devops_api:latest
                    """
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }
}
}
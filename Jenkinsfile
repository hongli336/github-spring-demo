pipeline {
    agent any

    environment {
        JAVA_HOME = '/opt/homebrew/opt/openjdk@21'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    sh '/opt/homebrew/bin/mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh '/opt/homebrew/bin/mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy your application, e.g., copy the war file or Docker commands
                    echo 'Deploying application...'
                }
            }
        }
    }
}
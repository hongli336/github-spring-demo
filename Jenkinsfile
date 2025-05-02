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

        stage('Run') {
            steps {
                script {
                    // run your application
                    sh 'nohup /opt/homebrew/bin/mvn spring-boot:run &'
                }
            }
        }
    }
}
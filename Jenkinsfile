pipeline {
    agent any

    environment {
        JAVA_HOME = '/opt/homebrew/opt/openjdk@21'
        SPRING_DATASOURCE_PASSWORD = credentials('spring-datasource-password')
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
                    sh '/opt/homebrew/bin/mvn spring-boot:run'
                }
            }
        }
    }
}
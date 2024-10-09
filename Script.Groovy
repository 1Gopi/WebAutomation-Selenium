pipeline {
    agent any

    stages {
        stage('Get SourceCode') {
            steps {
                git branch: 'main', credentialsId: '72e8e719-85c1-4153-afc0-2bfe2c293625', url: 'https://github.com/1Gopi/WebAutomation-Selenium.git'
                echo 'Get Source Code'
            }
        }
        stage('Build code'){
            steps{
                bat script: 'mvn compile'
            }
        }
        stage('Build clean'){
            steps{
                bat script: 'mvn clean'
            }
        }
        stage('Test'){
            steps{
                bat script: 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }
        stage('Reporting') {
                steps {
                    allure includeProperties:
                     false,
                     jdk: '',
                     results: [[path: 'Selenium Web Aut practise/allure-results']]
                }
    }
    }
}

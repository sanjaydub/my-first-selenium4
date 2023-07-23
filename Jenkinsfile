pipeline {
    agent any
    stages {
        stage('Checkin Maven & Java') {
            steps {
                echo 'Hello World'
                sh 'mvn -version'
                sh 'java -version'
            }
        }
        
        stage('Fetching from GitHUb') {
            steps{
                git url: 'https://github.com/sanjaydub/Allure_Maven_TestNG.git'
            }
        }
    
        stage('Building the code'){
            steps{
                sh 'mvn clean install -DskipTests'
            }
        }
    
        stage('Executing Automated Testcases'){
            steps{
                sh 'mvn test'
            }
        }
        
        stage('Capture Allure report'){
            steps{
                allure includeProperties: false, jdk: '', properties: [[key: 'allure.issues.tracker.pattern', value: 'http://example.com/%s']], report: 'target/allure-report', results: [[path: 'target/allure-results']]
            }
        }
    }  
    
    
}
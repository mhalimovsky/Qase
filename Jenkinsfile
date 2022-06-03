pipeline {
    agent any

    tools {
        maven "3.8.5"
     }

    parameters {
    gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
   }

    stages {
        stage('Test') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/mhalimovsky/Qase.git'
                sh "mvn clean test"

            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('reports') {
            steps {
                script {
                        allure([
                               includeProperties: false,
                               jdk: '',
                               properties: [],
                               reportBuildPolicy: 'ALWAYS',
                               results: [[path: 'target/allure-results']]
                        ])
                }
            }
        }
    }
}
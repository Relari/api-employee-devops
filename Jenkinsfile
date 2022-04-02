pipeline {
    agent any
    
    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Build Project'
                //git 'https://github.com/Relari/Employee-Mock-Docker.git'
                bat "mvn -Dmaven.test.skip=true clean package"
            }
        }
        
        stage('Test') {
            steps {
                echo 'Test App'
                bat "mvn clean install"
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploy App'
            }
        }
    }
    
    post {
        /**always {
            emailext body: 'Summary', subject: 'Pipeline Status', to: 'renzolavador@gmail.com'
        }*/
        
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}

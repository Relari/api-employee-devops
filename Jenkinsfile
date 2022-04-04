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

        stage('Code Coverage') {
            steps {
                publishHTML (target: [
                    reportDir: 'target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'JacocoReport'

                ])
            }
        }
        
        stage('Analize SonarQube') {
            steps {
                echo "Analize SonarQube"
                sh """
                mvn clean verify sonar:sonar -Dsonar.projectKey=EmployeeMockDocker -Dsonar.host.url=http://localhost:9000 -Dsonar.login=254898c9a5cd5ad68d2b02958190aed305afe041
                """
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Build Docker Image"
                bat "docker build -t employee ."
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploy App'
                sh """
                    docker run --name service-api-employee -it -p 8081:8081 employee
                """
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

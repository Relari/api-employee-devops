pipeline {

//     node {
//         def pom = readMavenPom()
//         def artifactId = pom.artifactId
//         def version = pom.version
//     }

    agent any
    
    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Clean And Build') {
            steps {
                sh "mvn clean install"
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

        stage('Values') {
            steps {
//                  IMAGE = readMavenPom().getArtifactId()
//                  VERSION = readMavenPom().getVersion()
//                  echo "IMAGE: ${artifactId}"
//                  echo "VERSION: ${version}"

                script {
                        pom = readMavenPom(file: 'target/pom-effective.xml')
                        projectArtifactId = pom.getArtifactId()
                        projectGroupId = pom.getGroupId()
                        projectVersion = pom.getVersion()
                        projectName = pom.getName()
                }

                echo "Building ${projectArtifactId}:${projectVersion}"
            }
        }
        
//         stage('Analize SonarQube') {
//             steps {
//                 echo "Analize SonarQube"
//                 sh """
//                 mvn clean verify sonar:sonar -Dsonar.projectKey=EmployeeMockDocker -Dsonar.host.url=http://localhost:9000 -Dsonar.login=254898c9a5cd5ad68d2b02958190aed305afe041
//                 """
//             }
//         }

//         stage('Build Docker Image') {
//             steps {
//                 echo "Build Docker Image"
//                 bat "docker build -t employee ."
//             }
//         }
//
//         stage('Deploy') {
//             steps {
//                 echo 'Deploy App'
//                 sh """
//                     docker run --name service-api-employee -it -p 8081:8081 employee
//                 """
//             }
//         }
    }
    
    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
            slackSend message: "Build Success - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
        failure {
            slackSend message: "Build Failure - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
//         always {
//             slackSend message: "Build Always - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
//         }
    }
}

pipeline {

    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        def archivePom = readMavenPom()

        IMAGE = archivePom.getArtifactId()
        VERSION = archivePom.getVersion()

        def dockerImage = ""

        SECRET_TEXT = credentials('SonarQube-Credential')

        gitcommit = "${gitcommit}"

    }
    
    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build And Unit Test') {
            steps {
                sh "mvn clean install"
            }
        }

        // stage('Code Coverage') {
        //     steps {
        //         publishHTML (target: [
        //             reportDir: 'target/site/jacoco',
        //             reportFiles: 'index.html',
        //             reportName: 'JacocoReport'

        //         ])
        //     }
        // }

        // stage('Values') {
        //     steps {
        //          echo "IMAGE: ${IMAGE}"
        //          echo "VERSION: ${VERSION}"

        //         script {
        //             def pom = readMavenPom file: 'pom.xml'
        //             def projectArtifactId = pom.artifactId
        //             def projectVersion = pom.version

        //             echo "Building ${projectArtifactId}:${projectVersion}"
        //         }

        //     }
        // }

//         stage('Create Branch') {
//             steps {
//                 bat 'git branch RC-${IMAGE}:${VERSION}'
//                 bat 'git push'
//             }
//         }
        
        // stage('Analyze SonarQube') {
        //     steps {
        //         sh "mvn clean verify sonar:sonar \
        //               -Dsonar.projectKey=employee-mock-docker \
        //               -Dsonar.host.url=http://192.168.43.222:9000 \
        //               -Dsonar.login=d3fdc4c23dec2dec8caf4137e3cfe3f03f8d7429"
        //     }
        // }

//         stage('Analyze SonarQube') {
//             steps {
//                 sh "mvn clean verify sonar:sonar \
//                       -Dsonar.projectKey=${IMAGE} \
//                       -Dsonar.host.url=http://192.168.43.222:9000 \
//                       -Dsonar.login=${SECRET_TEXT}"
//             }
//         }

        stage('Analyze SonarQube') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn clean verify sonar:sonar'
                }
            }
        }

//         stage('Build Docker Image') {
//             steps {
//
//                 // script {
//                 //     dockerImage = docker.build "relari/${IMAGE}"
//                 // }
//
//                 sh "docker build -t relari/${IMAGE}:${gitcommit} ."
//             }
//         }
        // stage('Docker Build & Push') {
        //   steps {
        //     script {  
        //       docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
        //         def appmavenjenkins = docker.build("relari/${IMAGE}:${gitcommit}", ".")
        //         appmavenjenkins.push()
        //       }
        //     }  
        //   }  
        // }
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

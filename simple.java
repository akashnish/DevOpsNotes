pipeline {
    agent any



   stages {
        stage('CheckOut') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'Github_Token', url: 'https://github.com/ShekarG21/java-reachability-playground.git']]])
            }
        }
        stage('Snyk') {
            steps {
            snykSecurity failOnIssues: false, organisation: '464d3fa1-09b2-4f83-967b-555011147f01', snykInstallation: 'SnykInstallation', snykTokenId: 'Snyk_Token'
            }
        }
    }
}

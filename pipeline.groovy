pipelineJob('pipeline') {
  definition {
    cps {
      script(
'''pipeline {
    agent {
        docker {
            image 'pipeline/jenkins\'
            args '-u 0:0 -v /var/run/docker.sock:/var/run/docker.sock\'
        }
    }
    stages {
        stage('git') {
            steps {
                echo 'cloning the repository\'
                // git branch: 'main', credentialsId: 'github-credentials', url: 'https://repositoryURL\'
                sh 'docker run hello-world\'
            }
        }
        stage('unit_test') {
            steps {
                sh 'echo "start the unit test"\'
            }
        }
        stage('build') {
            steps {
                sh 'echo "login to the GitHub container registry"\'
                // Supprimez le bloc withCredentials actuel et utilisez plutôt votre identifiant GitHub et un jeton d'accès personnel pour vous connecter
                sh 'docker login docker.pkg.github.com -u $GITHUB_USERNAME -p $GITHUB_TOKEN\'
                sh 'echo "building and pushing images to the container registry"\'
            }
        }
    }
}
''')
    }
  }
}

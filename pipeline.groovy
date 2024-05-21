pipelineJob('pipeline') {
  definition {
    cps {
      script(
              '''pipeline {
    agent any
    
    stages {
        stage('Display Maven Version') {
            steps {
                // Affichage de la version de Maven
                sh 'mvn --version'
            }
        }
    }
}
''')
    }
  }
}

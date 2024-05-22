pipelineJob('pipeline') {
    definition {
        cps {
            script(
                    '''
                pipeline {
                    agent {
                        docker {
                            image 'pipeline/jenkins'
                            args '-u 0:0 -v /var/run/docker.sock:/var/run/docker.sock'
                        }
                    }
                    stages {
                        stage('Display Maven Version') {
                            steps {
                                // Affichage de la version de Maven
                                sh 'mvn --version'
                            }
                        }
                    }
                }
                '''
            )
        }
    }
}

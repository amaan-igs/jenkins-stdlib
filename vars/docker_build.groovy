def call(String projectName, String imageTag, String dockerHubUser) {
    def imageName = dockerHubUser ? "${dockerHubUser}/${projectName}:${imageTag}" : "${projectName}:${imageTag}"
    
    sh "docker build -t ${imageName} ."
}
def call(String projectName, String imageTag, String dockerHubUser) {

    if (!projectName || !imageTag || !dockerHubUser) {
        error("Required parameters are missing: Please provide ProjectName, ImageTag, and DockerHubUser.")
    }
    
    // Docker build command
    sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
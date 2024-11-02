def call(String project, String imageTag, String dockerUser) {
    withCredentials([usernamePassword(credentialsId: "HubDocker", 
                                     passwordVariable: "HubDockerPass", 
                                     usernameVariable: "HubDockerUser")]) {
        // Log in to Docker Hub
        sh "docker login -u ${env.HubDockerUser} -p ${env.HubDockerPass}"
        
        echo "Docker username is: ${HubDockerUser}"
        
        // Tag the image with Docker Hub repository
        sh "docker image tag ${project}:${imageTag} ${dockerUser}/${project}:${imageTag}"
        
        // Push the tagged image to Docker Hub
        sh "docker push ${dockerUser}/${project}:${imageTag}"
        
        // Log out after pushing
        sh "docker logout"
    }
}

def call(String project, String imageTag) {
    withCredentials([usernamePassword(credentialsId: "HubDocker", 
                                     passwordVariable: "env.HubDockerPass", 
                                     usernameVariable: "env.HubDockerUser")]) {
        // Log in to Docker Hub
        sh "echo ${env.HubDockerPass} | docker login -u ${env.HubDockerUser} --password-stdin"
        
        // Tag the image with Docker Hub repository
        sh "docker image tag ${project}:${imageTag} ${env.HubDockerUser}/${project}:${imageTag}"
        
        // Push the tagged image to Docker Hub
        sh "docker push ${env.HubDockerUser}/${project}:${imageTag}"
        
        // Log out after pushing
        sh "docker logout"
    }
}

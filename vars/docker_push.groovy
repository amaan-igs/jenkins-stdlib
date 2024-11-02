def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Log in to Docker Hub
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"

        // Tag the image with Docker Hub repo
        sh "docker tag ${project}:${imageTag} ${dockerHubUser}/${project}:${imageTag}"

        // Push the tagged image to Docker Hub repo
        sh "docker push ${dockerHubUser}/${project}:${imageTag}"

        // Log out after pushing
        sh "docker logout"
    }
}

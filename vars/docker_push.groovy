def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Print out variables for debugging
        echo "Docker Hub User: ${dockerHubUser}"
        echo "Docker Hub Project: ${project}"
        echo "Image Tag: ${imageTag}"

        // Log in to Docker Hub
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"

        // Tag the image with Docker Hub repo
        sh "docker tag ${project}:${imageTag} ${dockerHubUser}/${project}:${imageTag}"

        // Push the tagged image to Docker Hub repo
        sh "docker push ${dockerHubUser}/${project}:${imageTag}"

        // Log out after pushing
        sh "docker logout"
    }
}

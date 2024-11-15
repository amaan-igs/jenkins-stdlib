# Jenkins Shared Library

This repository contains a Jenkins Shared Library for use in Jenkins pipelines. Shared libraries allow you to encapsulate common logic and functions, making it easier to maintain and share code across multiple pipelines and projects.

## Creating a Shared Library

1. **Login to your Jenkins dashboard.**
2. **Go to** `Manage Jenkins` > `Configure System`.
3. **Search for** `Global Trusted Pipeline Libraries`.
4. **Add a new library** with the following details:
   - **Name:** `jenkins-stdlib`
   - **Default version:** `<branch name>` (e.g., `main`)
   - **Project repository:** `https://github.com/amaan-igs/jenkins-stdlib.git`

## Using the Shared Library in Jenkins Pipeline

To use the shared library in your Jenkins pipeline, follow these steps:

1. Open your declarative pipeline script.
2. At the very first line of your Jenkins pipeline, add the following line:

   ```groovy
   @Library('jenkins-stdlib') _
   ```

## Example Pipeline Usage

Here’s a simple example of how to use a function from your shared library in a Jenkins pipeline:

![image](https://github.com/user-attachments/assets/db2ad365-63b0-477a-93e5-c0db1fce654e)


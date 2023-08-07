# jenkins-agents
Deploy a Jenkins server with two agents - dockerized

This setup use three vitual machines:
    - Jenkins master - master01
    - agent one - agent01
    - agent two - agent02

Jenkins master runs in a docker container builded during the deploy from image: jenkins/jenkins:lts (the image and version could be changed in roles/jenkins_master vars/main.yml)
Both agents are run in separate virtual machines as a docker container also builded during the deploy. The source image is: jenkins/inbound-agent

In order to use it needs to setup environment variables:
- in the inventory.ini file need to setup the IP addresses of the machines and the ansible user
- check and edit variables files - vars/main.yml in both roles jenkins_master and jenkins_slaves
- also be aware that maybe need to define all hosts and IP addresses in /etc/hosts

# jenkins-agents
Deploy a Jenkins server with two agents - dockerized


In order to use it needs to setup environment variables:
- in the inventory.ini file need to setup the IP addresses of the machines and the ansible user
- check and edit variables files - vars/main.yml in both roles jenkins_master and jenkins_slaves

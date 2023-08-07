FROM jenkins/jenkins:lts

ENV JENKINS_USER jenkins
ENV JENKINS_PASS admin
ENV JENKINS_SLAVE_AGENT_PORT 50000

ENV JAVA_OPTS="-Xmx4096m"
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
#ENV JENKINS_OPTS="--logfile=/var/jenkins_home/jenkins-master.log"

COPY --chown=$JENKINS_USER:$JENKINS_USER plugins.txt /tmp/plugins.txt
#COPY --chown=$JENKINS_USER:$JENKINS_USER scripts/*.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY --chown=$JENKINS_USER:$JENKINS_USER scripts/unlock_jenkins.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY --chown=$JENKINS_USER:$JENKINS_USER scripts/add_jenkins_user.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY --chown=$JENKINS_USER:$JENKINS_USER scripts/executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY --chown=$JENKINS_USER:$JENKINS_USER scripts/add_agent*.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN echo 2.7.1 > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state
RUN echo 2.7.1 > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion


RUN jenkins-plugin-cli -f /tmp/plugins.txt
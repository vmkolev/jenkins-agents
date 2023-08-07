import jenkins.model.Jenkins
import hudson.security.*

def jenkinsInstance = Jenkins.getInstance()

def domain = new Domain('example.com', 'Jenkins Domain') // Change these settings
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()

jenkinsInstance.setSecurityRealm(new HudsonPrivateSecurityRealm(false, domain, strategy))
jenkinsInstance.save()

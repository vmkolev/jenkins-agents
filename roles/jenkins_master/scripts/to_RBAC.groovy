import jenkins.model.Jenkins
import hudson.security.*

def jenkinsInstance = Jenkins.getInstance()

// change the Authorization strategy to "Role-Based Strategy" (RBAC)
def strategy = new GlobalMatrixAuthorizationStrategy()
jenkinsInstance.setAuthorizationStrategy(strategy)
jenkinsInstance.save()

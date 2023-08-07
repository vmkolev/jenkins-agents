import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

def instance = Jenkins.getInstance()
def global_domain = Domain.global()

def credentials_store = SystemCredentialsProvider.getInstance()

def agent_username = "${agent_username}"
def jenkins_user_ssh_key = "${jenkins_user_ssh_key}"
def nodeCredentialID = "${nodeCredentialID}"

println("Number of Executors: ${agent_username}")
println("Number of Executors: ${jenkins_user_ssh_key}")
println("Number of Executors: ${nodeCredentialID}")

def node_cred = credentials_store.getCredentials(global_domain).find {
    if (it instanceof com.cloudbees.jenkins.plugins.sshcredentials.SSHUserPrivateKey) {
      it.getPrivateKeySource().privateKeyFile.contains(jenkins_user_ssh_key)
    }
}

if (!node_cred) {
    credentials = new BasicSSHUserPrivateKey(
        CredentialsScope.SYSTEM,
        nodeCredentialID,
        agent_username,
        new BasicSSHUserPrivateKey.FileOnMasterPrivateKeySource(jenkins_user_ssh_key),
        "",
        "SSH Key for Jenkins Agents"
    )

    credentials_store.addCredentials(global_domain, credentials)
    credentials_store.save()
    instance.save()

    return "changed node sshkey"
}
import hudson.slaves.*
import hudson.model.*
import jenkins.model.Jenkins

def jenkins = Jenkins.getInstance()
def launcher
def nodeName = "agent02"
int nodePort = Integer.parseInt("22")
int node_numExecutors = Integer.parseInt("6")
def nodeRemoteFS = "/home/jenkins/jenkins-agent"
def node_mode = "NORMAL"

ComputerLauncher nodeLauncher = new hudson.slaves.JNLPLauncher()
Node node = new DumbSlave(
		nodeName,
		nodeRemoteFS,
		nodeLauncher)

node.setNumExecutors(node_numExecutors)
node.setLabelString("agent-" + nodeName)
node.setMode(Node.Mode.valueOf(node_mode))
jenkins.addNode(node)

println("Agent ${nodeName} has been created successfully.")
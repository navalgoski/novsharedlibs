def call (ip, user, credId){
  sshagent([credId]) {
    sh "mv target/myweb*.war target/myweb.war"
    // copy war
    sh "scp -o StrictHostKeyChecking=no target/myweb.war ${user}@${ip}:/opt/tomcat10/webapps"
    // stop tomcat
    sh "ssh ${user}@${ip} /opt/tomcat10/bin/shutdown.sh"
    // start tomcat
    sh "ssh ${user}@${ip} /opt/tomcat10/bin/startup.sh"
  }
}

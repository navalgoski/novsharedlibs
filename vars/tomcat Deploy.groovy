def call (ip, user, credId){
  sshagent ([credId]) {
    sh "mv target/myweb*.war target/app.war"
    // copy war
    sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat10/webapps"
    // stop tomcat
    sh "ssh ${user}@${ip} /opt/tomcat10/bin/shutdown.sh"
    // start tomcat
    sh "ssh ${user}@${ip} /opt/tomcat10/bin/startup.sh"
  }
}

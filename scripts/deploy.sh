ant clean
ant
ant -f buildWar.xml create

yes | cp ROOT.war /opt/tomcat/webapps/ROOT.war

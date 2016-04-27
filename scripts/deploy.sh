ant clean
ant -f build2.xml
ant -f buildWar.xml create

yes | cp ROOT.war /opt/tomcat/webapps/ROOT.war

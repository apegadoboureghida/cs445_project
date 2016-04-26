#Installing Java8
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer

#Set Java8 as default
sudo apt-get install oracle-java8-set-default

wget http://mirrors.gigenet.com/apache/tomcat/tomcat-8/v8.0.33/bin/apache-tomcat-8.0.33.zip
unzip apache-tomcat-8.0.33.zip
sudo mv apache-tomcat-8.0.33 /opt/tomcat
chmod 744 /opt/tomcat/bin/*sh
rm apache-tomcat-8.0.33.zip

sudo apt-get install ant

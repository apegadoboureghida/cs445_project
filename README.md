# cs445-project Delectable
## Installing Environment

Run install_environment.sh and follow the instructions.
This script is going to install:
    
  - [Oracle Java8]
  - [Apache Tomcat]

``` 
sh scripts/install_environment.sh
```
## Build
This script generate the .class files from source.
``` 
ant
```
> To create the .war file go to Deploy

## Run Test and Converture test

The test are coded using [Junit4] and run by a custom main class.

The library used to measure the coverage is [Jcov].


``` 
sh scripts/runTest.sh 
```

Once Jcov have already finished, one new folder is created. To check this test open:

> report/index.html

## Deploy
To deploy the project run:

``` 
ant clean
ant
ant -f buildWar.xml deploy
```

> Note: The project is going to be deploy in the root folder of Tomcat and port 8080
> (ex: http://localhost:8080/menu) 

> This create two .war files one in the main folder of the project and another one (a copy) on tomcat folder.

## Repository
> This repository is stored in [Github]: https://github.com/apegadoboureghida/cs445_project/

License
----

MIT


**Free Software, Hell Yeah!**

   [Junit4]: <http://junit.org/junit4/>
   [Jcov]: <https://wiki.openjdk.java.net/display/CodeTools/jcov>
   [Github]: <https://github.com>
   [oracle java8]: <http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html>
   [apache tomcat]: <http://tomcat.apache.org/>



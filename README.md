# cs445-project Delectable
## Installing Environment

Run install_environment.sh and follow the instructions.
This script is going to install:
    
  - Java8
  - Tomcat

``` 
sh scripts/install_environment.sh
```
## Build
This script generate the .class files from source.
``` 
ant
```

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

License
----

MIT


**Free Software, Hell Yeah!**

   [Junit4]: <http://junit.org/junit4/>
   [Jcov]: <https://wiki.openjdk.java.net/display/CodeTools/jcov>



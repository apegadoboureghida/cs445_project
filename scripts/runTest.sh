rm result.xml result2.xml
rm -r build-Instr/
cp -r build/ build-Instr/
java -jar jcov.jar Instr -recursive build/
java -classpath build-Instr/classes/:lib/junit.jar:lib/org.hamcrest.core_1.3.0.v201303031735.jar:WebContent/WEB-INF/lib/gson-2.6.2.jar -javaagent:jcov.jar main
java -jar jcov.jar Filter -include edu.* result.xml result2.xml
java -jar jcov.jar RepGen result2.xml

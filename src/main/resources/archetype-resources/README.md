Project Name Here
---
Some description of your project here.

Build
---
mvn clean package

Release
---
mvn --batch-mode release:prepare release:perform

Run
---
java -Dlog4j.configuration=file:///some/dir/conf/log4j.xml \
  -jar [artifact]-war-exec.jar -loggerName slf4j

For the complete list of options for the tomcat7 plugin look here:
http://tomcat.apache.org/maven-plugin-trunk/executable-war-jar.html
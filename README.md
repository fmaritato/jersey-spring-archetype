Jersey + Spring Maven Archetype
--
This archetype will bootstrap a maven project for you that is a rest service using
Jersey and Spring. It comes with an example on how to do the Resource classes and
how to create unit tests for said resources. It also provides a plugin to create
an "executable war".

Build
--
mvn install

Generate a project
--
```
mvn archetype:generate                          \
  -DarchetypeGroupId=com.maritatf.archetypes    \
  -DarchetypeArtifactId=jersey-spring-archetype \
  -DarchetypeVersion=$ARCH_VERSION              \
  -DinteractiveMode=false                       \
  -DgroupId=$GROUP                              \
  -DartifactId=$ARTIFACT                        \
  -Dversion=$VERSION
```

Launch project
--
java -jar [artifact]-war-exec.jar

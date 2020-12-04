##
## Stay cheap. Greedy. Stay hungry. There's plenty of time later to bulk up on
## heap space.
##
MVN_OPTS := -Xms100m -Xmx200m
MVN      ?= $(shell pwd)/mvnw
##
## What can I say. I do enjoy that one-command feel, as I swiftly type `make`
## and press the Enter key. A rush and warm feeling spreading through by body,
## as the terminal scroll by and the familiar startup ASCII logo rolls by...
##
## ..starting!
##
## Just run `make`.
##
.PHONY: start
start:
	JAVA_HOME=`/usr/libexec/java_home 15`; \
	  MAVEN_OPTS="$(MVN_OPTS)"; \
	  $(MVN) spring-boot:run

MVN_OPTS  := -Xms100m -Xmx200m
MVN       ?= $(shell pwd)/mvnw
JAVA_HOME := $(shell /usr/libexec/java_home -v 11)

.PHONY: start
start:
	SPRING_PROFILES_ACTIVE=dev $(MVN) spring-boot:run

.PHONY: test
test:
	$(MVN) clean verify

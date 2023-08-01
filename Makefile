MVN_OPTS  := -Xms100m -Xmx200m
MVN       ?= $(shell pwd)/mvnw
JAVA_HOME := $(shell /usr/libexec/java_home -v 11)

.PHONY: start
start:
	SPRING_PROFILES_ACTIVE=dev $(MVN) spring-boot:run

.PHONY: test verify v
test t verify v:
	$(MVN) clean verify

.PHONY: image
image:
	$(MVN) spring-boot:build-image

.PHONY: tidy
tidy:
	$(MVN) formatter:format

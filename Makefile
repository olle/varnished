MVN_OPTS  := -Xms100m -Xmx200m
MVN       ?= $(shell pwd)/mvnw
JAVA_HOME := $(shell /usr/libexec/java_home -v 21)
SPRING_PROFILES_ACTIVE ?= dev

.PHONY: start
start:
	SPRING_PROFILES_ACTIVE=$(SPRING_PROFILES_ACTIVE) $(MVN) spring-boot:run

.PHONY: test verify v
test t verify v:
	$(MVN) clean verify

.PHONY: image
image:
	$(MVN) spring-boot:build-image

.PHONY: tidy
tidy:
	$(MVN) formatter:format

.PHONY: up down
up:
	docker-compose up -d

down:
	docker-compose down --remove-orphans


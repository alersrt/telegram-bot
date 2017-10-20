###########################
### Git Section
###########################

MAINLINE_BRANCH := dev
CURRENT_BRANCH := $(shell git branch | grep \* | cut -d ' ' -f2)

# Squash changes of the current Git branch onto another Git branch.
#
# WARNING: You must merge `onto` branch in the current branch before squash!
#
# Usage:
#	make squash [onto=] [del=(no|yes)]

onto ?= $(MAINLINE_BRANCH)
del ?= no
upstream ?= origin

squash:
ifeq ($(CURRENT_BRANCH),$(onto))
	@echo "--> Current branch is '$(onto)' already" && false
endif
	git checkout $(onto)
	git branch -m $(CURRENT_BRANCH) orig-$(CURRENT_BRANCH)
	git checkout -b $(CURRENT_BRANCH)
	git branch --set-upstream-to $(upstream)/$(CURRENT_BRANCH)
	git merge --squash orig-$(CURRENT_BRANCH)
ifeq ($(del),yes)
	git branch -d orig-$(CURRENT_BRANCH)
endif

###########################
### Docker section
###########################

#clean command
clean:
	docker run --rm -v ${PWD}:/home/gradle/project -w /home/gradle/project \
    gradle:latest gradle clean

# build command
build:
	docker run --rm -v ${PWD}:/home/gradle/project -w /home/gradle/project \
	gradle:alpine gradle  build -x test

# run command
run: | build
	docker run --rm -v ${PWD}:/usr/myapp -w /usr/myapp openjdk:alpine \
	java -jar build/libs/time-api-1.0.jar

# docs command
docs:
	docker run --rm -v ${PWD}:/home/gradle/project -w /home/gradle/project \
	gradle:alpine gradle javadoc

# test command
test:
	docker run --rm -v ${PWD}:/home/gradle/project -w /home/gradle/project \
    gradle:alpine gradle test jacocoTestReport \
    jacocoTestCoverageVerification pitest

# lint command
lint:
	docker run --rm -v ${PWD}:/home/gradle/project -w /home/gradle/project \
    gradle:alpine gradle pmdMain pmdTest

.PHONY: clean docs test lint run build squash

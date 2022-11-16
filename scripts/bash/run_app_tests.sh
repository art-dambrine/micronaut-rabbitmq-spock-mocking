#!/bin/bash
set -xe

#./grailsw -Dgrails.env=test -Dbase.dir=. test-app -unit
#./grailsw -Dgrails.env=test -Dbase.dir=. test-app -integration --offline --stacktrace
#./grailsw -Dgrails.env=test -Dbase.dir=. test-app -functional --offline --stacktrace

./gradlew check
#./gradlew test
#./gradlew integrationTest

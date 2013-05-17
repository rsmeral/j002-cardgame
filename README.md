Card Game EE
============

Quick and **very dirty** Java EE implementation of a simple card game.

Every round a card is drawn from a deck and players bet whether the next one will be of higher or lower rank.

## Installation

Deploy the application to a JBoss AS instance and visit [http://localhost:8080/cardgamee](http://localhost:8080/cardgamee).
Use Maven's deploy phase to have the built WAR deployed to a running local JBoss AS instance:

    mvn clean deploy

Manual deployment is possible using `jboss-cli`:

    $JBOSS_HOME/bin/jboss-cli.sh "connect, deploy j002-cardgame/target/cardgamee.war"

Application was designed for JBoss AS 7.1.1 but might work on other EE servers as well.

### Running JBoss AS

1. Get JBoss AS at http://www.jboss.org/jbossas/downloads
2. Set `JBOSS_HOME` environment variable to the unpacked JBoss AS folder, e.g. `/opt/jboss-as-7.1.1.Final`
3. Start JBoss AS: `$JBOSS_HOME/bin/standalone.sh`

---
_Card Gamee EE is a project for the course J002 Requirements Engineering in Agile Software Development at FI MUNI._

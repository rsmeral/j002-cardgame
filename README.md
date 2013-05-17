Card Game EE
============

Quick and **very dirty** Java EE implementation of a simple card game.

Every round a card is drawn from a deck and players bet whether the next one will be of higher or lower rank.

---
_CardGamEE is a project for the course J002 Requirements Engineering in Agile Software Development at FI MUNI._

Installation instructions:

Application was designed for JBoss 7.1.1 application server.

- mvn clean install


If you're going to use JBoss, start JBoss server as:

- $JBOSS_HOME/bin/standalone.sh

Deploy cardgamee.war on application server:
- $JBOSS_HOME/bin/jboss-cli.sh "connect, deploy j002-cardgame/target/cardgamee.war --force"

(--force parameter is for redeployment)

Application should run on 
[Localhost](http://localhost:8080/cardgamee)

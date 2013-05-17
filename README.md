Card Game EE
============

Quick and **very dirty** Java EE implementation of a simple card game.

Every round a card is drawn from a deck and players bet whether the next one will be of higher or lower rank.

---
_CardGamEE is a project for the course J002 Requirements Engineering in Agile Software Development at FI MUNI._

Installation instructions:

You need JBoss 7.2+ application server (haven't tested others)
JBoss AS 7.2.0.Final ZIP 
https://www.dropbox.com/s/gbbill0iyf4pmcg/jboss-as-7.2.0.Final.zip
1)
mvn clean deploy

OR 
2)
mvn clean install
start JBoss server via 
$JBOSS_HOME/bin/standalone.sh

$JBOSS_HOME/bin/jboss-cli.sh "connect, deploy j002-cardgame/target/cardgamee.war --force"
(--force parameter is for redeployment)

Application should run on 
localhost:8080/cardgamee

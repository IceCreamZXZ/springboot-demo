# springboot-demo
Ein Beispiel project um die Grundlagen von Spring-Boot zu verstehen.

WICHTIG: Java jre 17 ist zwangsläufig nötig.

Diese Programm ist für die MySQL Datenbank geschrieben falls ihr eine andere Datenbank benutzt müsst ihr euch den entsprechenden Driver runterladen und die URL in src/main/resources/application.properties
anpassen.

Es muss außerdem bereits eine Datenbank existieren wenn eure Datenbank demo heißt sind keine weiteren Konfigurationen nötig. Ihr könnt diese Datenbank auch mit dem folgenden Command erstellen:
CREATE DATABASE demo;

Falls eure Datenbank einen anderen Namen hat müsst ihr in src/main/resources/application.properties die URL bearbeiten und das demo am Ende durch den Namen eurer Datenbank austauschen.

Falls ihr einen anderen Datenbank benutzer habt oder ein anderes Passwort festgelegt habt müsst ihr das in src/main/resources/application.properties ändern.

Falls ihr noch garkeinen Datenbank benutzer habt könnt ihr mit den folgenden Commands einen erstellen und müsst nichts in der application.properties verändern.

 Create User 'demoUser'@'localhost' Identified By 'password';
  Grant All Privileges On demo.* To 'demoUser'@'localhost'; 

# uek223

#Vorraussetzungen

Dieses Projetk setzt die Java Version 11 vorraus. 
Falls Sie diese Version noch nicht haben, installieren Sie diese unter der folgenden URL: 
https://www.oracle.com/java/technologies/downloads/
Wählen Sie die JDK Version entsprechend im Projekt aus. 

Klonen Sie das Projekt von dem Github Repository auf ihren Lokalen PC mit diesem Command.
git clone https://github.com/blerineberisha/uek223.git

Zusätzlich brauchen Sie einen Docker Container mit einer PostgreSQL Datenbank, welche auf Port 5432 läuft.
Aufsetzen der DB mit folgendem Command:
`docker run --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres`

Der Username und das Passwort für die Anmeldung sind beide "postgres".
Um den Username oder das Passwort zu ändern, navigieren Sie zu dem File "application.properties".

#Setup
Öffnen Sie die Applikation in IntelliJ. 
Starten Sie das Projekt nachdem alle Files indexiert und das Gradle Projekt gebuildet wurde. Dies erkennen Sie untern rechts an der Taskbar.

Wenn das Projekt erfolgreich aussgeführt wurde, sollten Sie auf der Konsole eine ähnliche Nachricht sehen
2021-11-12 15:09:02.678  INFO 8492 --- [main] com.example.demo.DemoApplication: Started DemoApplication in 6.002 seconds (JVM running for 6.697)

Gehen Sie nun auf die folgende URL --> http://localhost:8080/login
Melden Sie sich nun mit dem Username: "james" und dem Passwort: "bond" an.  
Wenn Sie alles richtig eingegeben haben, sollten Sie weitergeleitet werden. 
Sie sollten einen grossen Titel sehen auf dem Whitelabel Error Page steht. 

#Gewöhnliche Fehler & Lösungen
* Falls das Projekt nicht startet, überprüfen Sie ob der Docker Container läuft
* Stellen Sie sicher das eine Verbindung zu der Datenbank besteht
* Starten Sie das Projekt neu

#Tipps
* Sie können Ihrer Datenbank beim Start simulierte Daten hinzufügen, indem Sie ein SQL-Skript namens `data.sql` verwenden, das sich im Ressourcenordner befindet
* Sie können Statements beim Start ausführen, indem Sie sie zu `AppStartupRunner.run()` . hinzufügen

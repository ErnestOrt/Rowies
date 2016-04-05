# Rowies

### Version

1.0

### Description

Rowies provides you a way to evolve database schemas easily and reliably across different instances thanks to [Flywaydb](http://www.flywaydb.org)..

### How does the UI look like?

![Alt text](https://github.com/ErnestOrt/Rowies/blob/master/ScreenshotRowies.PNG)

### Required technologies

* Java 8
* Maven 3.0.5 

### Make me run

* Configure your ***DBs instances on databases.json*** (/flywaydb/src/main/resources/databases.json)

    * sorting: this number will be used to sorting all instances on UI.
    * imgCode: this String will be used to in order to relates an image to each instances (from 1 to 4).
    * code: this String will be used to identify uniquely.
    * name: instance name.
    * stringConnection: DB string connection.
    * user: DB user.
    * pass: DB password.

* Set your ***scripts locations on application.properties*** (/flywaydb/src/main/resources/application.properties) in order to not need to redeploy app when a script is added.
 
* Open a terminal and set yourself on application folder and execute: ***mvn spring-boot:run*** and go to http://localhost:18881/ (1881 is default port, change it on application.properties)


**Enjoy**

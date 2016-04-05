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


####Contributing
Start with clicking the star button to make the author and his neighbors happy :blush:. Then fork the repository and submit a pull request for whatever change you want to be added to this project.

If you have any questions, just open an issue.

####Licence

This project is released under the MIT licence.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

####Enjoy it Folks!

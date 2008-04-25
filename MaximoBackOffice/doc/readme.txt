Copyright 2008 Antonio Jacob Costa (jacob.costa@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at 

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License.


1. Introduction
---------------


2. Contents
-----------


3. Before you install
---------------------





4. Installation
---------------

4.1. Extract the zip file

Extract the zip file 


4.2. Copy files

Copy the contents of the _maximo_home folder to your MAXIMO home folder. 

The file maximo_backoffice_tools.xml will be created in the 
$MAXIMO_HOME/tools/maximo folder. 

4.3. Change web.xml

Change the web.xml descriptor. You'll need to set the MAXIMO_HOME parameter with
the location of your MAXIMO installation folder.


4.4. Deploy
Update the MAXIMO_HOME parameter with the Maximo's location.

Remove any pause statement from your configdb.bat, restorefrombackup.bat and 
dropbackup.bat script files. 

Deploy the WAR application in a BEA Weblogic or IBM WebSphere application server.


5. 
-
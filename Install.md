# Introduction #
Installation guide

# Contents #


# Before you install #


# Installation #


## Extract the zip file ##


## Copy files ##

Copy the contents of the _maximo\_home folder to your MAXIMO home folder._

The file maximo\_backoffice\_tools.xml will be created in the
$MAXIMO\_HOME/tools/maximo folder.

## Change web.xml ##

Change the web.xml descriptor. You'll need to set the MAXIMO\_HOME parameter with
the location of your MAXIMO installation folder.


## Deploy ##
Update the MAXIMO\_HOME parameter with the Maximo's location.

Remove any pause statement from your configdb.bat, restorefrombackup.bat and
dropbackup.bat script files.

Deploy the WAR application in a BEA Weblogic or IBM WebSphere application server.



---

3rd party adds

&lt;wiki:gadget url="https://sites.google.com/a/openmaximo.net/openmaximo/site-files/adsense.gadget.xml?attredirects=0" height="95" width="735" border="0" /&gt;
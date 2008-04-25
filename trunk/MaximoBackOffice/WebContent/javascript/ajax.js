/*
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
*/

// Controls if there is an action executing.
var executingCtrl = 0;

function clearResults() {
  var resParagraph = document.getElementById("resDiv");
  resDiv.innerText = "";
  var statusDiv = document.getElementById("statusDiv");
  statusDiv.innerText = "";
}

// Manages mouse cursor
function manageMouseOver(objI) {
  if (executingCtrl == 0) {
    document.body.style.cursor="hand";
    objI.style.className="menuover";
  }
}

// Manages mouse cursor
function manageMouseOut(objI) {
  if (executingCtrl == 0) {
    document.body.style.cursor="auto";
    objI.style.className="menu";
  }
}

function ajaxFunctionMenu(menuOption) {
  if (executingCtrl == 0) {
    clearResults();
    var statusDiv = document.getElementById("statusDiv");
    statusDiv.innerHTML = "<p>Trabajando para usted... <img id=workingImg src=images/loader_nobg.gif border=0 /></p>";
    var xmlHttp;
    try {  // Firefox, Opera 8.0+, Safari
      xmlHttp=new XMLHttpRequest();
    } catch (e) {  // Internet Explorer
      try {
        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      } catch (e) {
        try {
          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
          alert("Your browser does not support AJAX!");
          return false;
        }
      }
    }
    
    xmlHttp.onreadystatechange=function() {
      if(xmlHttp.readyState==4) {
        // Get the data from the server's response
        var resDiv = document.getElementById("resDiv");
        resDiv.innerHTML = xmlHttp.responseText;
        var statusDiv = document.getElementById("statusDiv");
        statusDiv.innerHTML = "<p>Listo</p>";
        document.body.style.cursor='auto';
        executingCtrl = 0;
      }
    }
    executingCtrl = 1;
    document.body.style.cursor="wait";
    var urlS = "ExecuteMaximo?option=" + menuOption;
    xmlHttp.open("POST",urlS,true);
    xmlHttp.send(null);
  }
}
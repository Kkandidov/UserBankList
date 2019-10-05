<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
     <title> Users-accounts </title>
	 <script>
	  function getRechestUser(){
      var xmlhttp;
      if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest();
      else xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
      xmlhttp.onreadystatechange = function() {
      if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
      document.getElementById("result").innerHTML=xmlhttp.responseText;
      }
      xmlhttp.open("GET", "/GettingRichestUserController", true);
      xmlhttp.send();
      }

   	  function getAccountsSum(){
      var xmlhttp;
      if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest();
      else xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
      xmlhttp.onreadystatechange = function() {
      if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
      document.getElementById("result1").innerHTML=xmlhttp.responseText;
      }
      xmlhttp.open("GET", "/GettingSumAccountsController", true);
      xmlhttp.send();
      }
	 </script>
   </head>
   <body>
    <h1> Users and Accounts </h1>
    <p><b>Rechest user</b>
    <input type="button" value= "get"onclick="getRechestUser()"> </p>
    <p><span id="result"></span></p>
	<p><b> Accounts sum </b>
    <input type="button" value= "get" onclick="getAccountsSum()"> </p>
    <p><span id="result1"></span></p>
   </body>
</html>
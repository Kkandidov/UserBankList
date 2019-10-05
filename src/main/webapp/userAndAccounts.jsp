</html><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
  <title> User and Accounts </title>
  <script>
   function getById() {
   var str = document.getElementById("number").value;
   var status = document.getElementById("status");
   if(isEmpty(str)) status.innerHTML = "Введите Id";
   else {
   const params = "user_id=" + str;
   var xmlhttp;
   if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest();
   else xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
   xmlhttp.open("POST", "/UserAndAccountsController", true);
   xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   xmlhttp.onreadystatechange = function() {
   if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
   status.innerHTML=xmlhttp.responseText;
   }
   xmlhttp.send(params);
   }
   }
   function isEmpty(str){ return (str == null) || (str.length == 0); }
   function getAllAccounts(){
   var xmlhttp;
   if (window.XMLHttpRequest) xmlhttp = new XMLHttpRequest();
   else xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
   xmlhttp.onreadystatechange = function() {
   if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
   document.getElementById("res").innerHTML=xmlhttp.responseText;
   }
   xmlhttp.open("GET", "/UserAndAccountsController", true);
   xmlhttp.send();
   }
   </script>
 </head>
 <body>
  <p><b> Returning from the users data table by id </b><p>
   <p> Enter id </p>
   <p><input type="text" id="number"> </p>
   <p><input type="button" value="Receive" onclick="getById()"></p>
   <p><span id="status"></span></p>

   <p><b> Returning all accounts </b></p>
   <p><input type= "button" value= "Receive" onclick = "getAllAccounts()"></p>
   <p><span id="res"></span></p>
 </body>
</html>
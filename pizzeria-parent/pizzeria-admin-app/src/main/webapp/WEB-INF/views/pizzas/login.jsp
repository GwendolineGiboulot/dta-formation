<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ici c'est le titre</title>

  <link rel='stylesheet' href=<c:url value='/css/bootstrap.min.css'></c:url>> 
  <script src="<c:url value='/js/jquery-1.12.4.min.js'></c:url>"></script>
  <script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
</head>
<body>


	


<div class='jumbotron'>
<div class='container'>

<h2> LE MEILLEUR MENU DE LOGIN DE L'UNIVERS</h2>

<c:if test="${erreur != null}">


<h1>${erreur}</h1>
</c:if>


	
<c:if test="${param.erreur != null}">

<c:if test='${param.erreur == "paslogue"}'>
<h1>Tu n'es pas logué, vil gredin</h1>
</c:if>

</c:if>

 <form action="<c:url value='/login'></c:url>" method="post">
 
 
 
 
	<table class='table'>
			
	<tr><td>Email </td><td> <input type='email' name='email'  > </td></tr>
	<tr><td>Mot de passe  </td><td> <input type='password' name='pass'>	</td></tr>
	<tr><td> <input type='submit' class='btn btn-success' value='VALIDER !!!!'> </td></tr>	
	</table>
	</form>


</div>
</div>
	




</body>
</html>
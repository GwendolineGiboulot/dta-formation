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


	

<div class='container'>
<div class='jumbotron'>


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
 
 
 
 

<div class="form-group">	
<label for="exampleInputEmail1">Email </label> <input  class="form-control" type='email' name='email'  >
    <small id="emailHelp" class="form-text text-muted">Nous ne partagerons JAMAIS votre email avec qui que ce soit.</small>
  </div> 
   <div class="form-group">
<label for="exampleInputPassword1">Password</label>  <input class="form-control" type='password' name='pass'>	
 </div>
 
 <input type='submit' class='btn btn-success' value='VALIDER !!!!'> 
</form>


</div>
</div>
	




</body>
</html>
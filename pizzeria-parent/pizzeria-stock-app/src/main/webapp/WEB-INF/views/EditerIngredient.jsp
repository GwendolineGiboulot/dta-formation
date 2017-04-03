<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@page import ="java.util.List" %>
    <%@page import="fr.pizzeria.model.Ingredient" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
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


<h2> LE MEILLEUR MENU D'EDITION D'INGREDIENT DE L'UNIVERS !!!!!</h2>


<form:form method="post" modelAttribute="ingre">
 
 <input type='hidden' name='oldCode' value='${ingre.id}'>
 
	<div class="form-group">	
	<label for="InputNom">Nom </label><form:input class="form-control" path="nom" />
	</div>
	<div class="form-group"> 
	<label for="InputPrix">Prix </label><form:input class="form-control" path="prix" />
	</div>
		<div class="form-group">
	<label for="InputQuantite">Quantite </label><form:input class="form-control" path="quantite" />
	</div>
	<input type='submit' class='btn btn-success' value='VALIDER !!!!'> 

	

	</form:form>


</div>
</div>
	




</body>
</html>
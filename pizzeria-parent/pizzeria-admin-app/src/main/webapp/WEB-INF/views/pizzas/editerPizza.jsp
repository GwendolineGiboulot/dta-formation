<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@page import ="java.util.List" %>
    <%@page import="fr.pizzeria.model.Pizza" %>
    
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


<h2> LE MEILLEUR MENU D'EDITION DE PIZZA AU MONDE</h2>


 <form action=<c:url value='/pizzas/edit'></c:url> method="post">
 
 <input type='hidden' name='oldCode' value='${pizza.code}'>
 
	<div class="form-group">	
	<label for="InputCode">Code </label>   <input class="form-control" type='text' name='code' value='${pizza.code}'> 
	</div>
		<div class="form-group"> 
	<label for="InputNom">Nom </label>  <input class="form-control" type='text' name='nom' value='${pizza.nom}'> 
	</div>
		<div class="form-group">
	<label for="InputPrix">Prix </label>  <input class="form-control"  type='number' name='prix' value='${pizza.prix}'>	
	</div>
		<div class="form-group">
	<label for="InputCategorie">Categorie </label>  <select class='selectpicker form-control' name='categorie'> <option>Viande</option><option>Poisson</option><option>Sans Viande</option></select>
	 </div>	
	<input type='submit' class='btn btn-success' value='VALIDER !!!!'> 

	

	</form>


</div>
</div>
	




</body>
</html>
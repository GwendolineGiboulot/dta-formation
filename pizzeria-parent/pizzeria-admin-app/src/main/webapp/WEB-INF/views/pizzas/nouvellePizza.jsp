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


	


<div class='jumbotron'>
<div class='container'>

<h2> LE MEILLEUR MENU D'AJOUT DE PIZZA AU MONDE</h2>

 <form action="<c:url value='/pizzas/new'></c:url>" method="post">
 
 
	<table class='table'>
			
	<tr><td>Code </td><td> <input type='text' name='code'  > </td></tr>
	<tr><td>Nom  </td><td> <input type='text' name='nom'>	</td></tr>
	<tr><td>Prix  </td><td> <input type='number' name='prix'>	</td></tr>	
	<tr><td>Categorie </td><td> <select class='selectpicker' name='categorie'> <option>Viande</option><option>Poisson</option><option>Sans Viande</option> </select></td></tr>
	<tr><td> <input type='submit' class='btn btn-success' value='VALIDER !!!!'> </td></tr>	
	</table>
	</form>


</div>
</div>
	




</body>
</html>
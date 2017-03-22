<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import ="java.util.List" %>
    <%@page import="fr.pizzeria.model.Pizza" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ici c'est le titre</title>

    <link rel='stylesheet' href='/pizzeria-admin-app/css/bootstrap.min.css'> 
   <script src='/pizzeria-admin-app/js/jquery-1.12.4.min.js'></script> 
  <script src='/pizzeria-admin-app/js/bootstrap.min.js'></script>
  </script>  
</head>
<body>




<div class='jumbotron'>
<div class='container'>

<h2> LE MEILLEUR MENU D'EDITION DE PIZZA AU MONDE</h2>

<%

Pizza pizza = (Pizza)request.getAttribute("pizza");



 %>
 <form action="/pizzeria-admin-app/pizzas/edit" method="post">
 
 <%= "</td><td> <input type='hidden' name='oldCode' value='"+ pizza.getCode() +"'>" %>
 
	<table class='table'>
			
	<tr><td><%= "Code </td><td> <input type='text' name='code' value='"+ pizza.getCode() +"'>" %> </td></tr>
	<tr><td><%= "Nom  </td><td> <input type='text' name='nom' value='"+ pizza.getNom() +"'>" %> 	</td></tr>
	<tr><td><%= "Prix  </td><td> <input type='number' name='prix' value='"+ pizza.getPrix() +"'>" %>	</td></tr>	
	<tr><td><%= "Categorie </td><td> <select class='selectpicker' name='categorie'> <option>Viande</option><option>Poisson</option><option>Sans Viande</option>  selected='selected+ "+pizza.getCategorie() +"'</select>" %>		</td></tr>
	<tr><td> <input type='submit' class='btn btn-success' value='VALIDER !!!!'> </td></tr>	
	</table>
	</form>


</div>
</div>
	




</body>
</html>
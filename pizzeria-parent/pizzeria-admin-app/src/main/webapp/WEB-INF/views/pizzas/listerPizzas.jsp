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
  <script src='/pizzeria-admin-app/js/script.js'>
  </script>  
</head>
<body>





<div class='container'>
<table class='table table-striped'>

 <thead>
    <tr>
    
      <th>Code Pizza</th>
      <th>Nom de la pizza</th>
      <th>Prix</th>
      <th>Categorie</th>
    </tr>
	</thead>
	<tbody>
<%
List<Pizza> lPiz = (List<Pizza>)request.getAttribute("lPizza");





for (Pizza pizza : lPiz) { %>

	<%= "<tr><td>" + pizza.getCode()  + "</td><td>" + pizza.getNom()  + "</td><td>" + pizza.getPrix() +"</td><td>" + pizza.getCategorie() + "</td><td>" +  "<a href=/pizzeria-admin-app/pizzas/edit?code="+ pizza.getCode()  +"><button class='btn'>Editer</button></a> <input type='button' class='btnX btn' value ='Supprimer'> " +  "</td></tr>"  %>

<%	
}

%>
</tbody>
</table>

<a href="/pizzeria-admin-app/pizzas/new">
   <input type="button" value="CREER UNE NOUVELLE PIZZA !!!!!!"  class ='btn btn-success'/>
</a>	

</div>
	
	





</body>
</html>
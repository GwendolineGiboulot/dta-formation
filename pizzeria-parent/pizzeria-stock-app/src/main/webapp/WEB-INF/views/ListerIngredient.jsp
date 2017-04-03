<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@page import ="java.util.List" %>
    <%@page import="fr.pizzeria.model.Ingredient" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ici c'est le titre</title>

  <link rel='stylesheet' href=<c:url value='/css/bootstrap.min.css'></c:url>> 
  <script src="<c:url value='/js/jquery-1.12.4.min.js'></c:url>"></script>
  <script src="<c:url value='/js/bootstrap.min.js'></c:url>"></script>
  <script src="<c:url value='/js/script.js'></c:url>"></script>
</head>
<body>

<div class='container'>



<table class='table table-striped'>

 <thead>
    <tr>
    
      <th>Id de l'ingrédient</th>
      <th>Nom</th>
      <th>Prix</th>
      <th>Quantité</th>
    </tr>
	</thead>
	<tbody>
	
<c:forEach var="ingre" items="${lIngr}">

<tr>
<td>${ingre.id}</td>
<td>${ingre.nom}</td>
<td>${ingre.prix}</td>
<td>${ingre.quantite}</td>


<td><a href=<c:url value='${applicationScope.springmvc}/ingredients/${ingre.id}'></c:url>><button class='btn btn-warning'>Editer</button></a></td>
<td>	

</c:forEach>
	
</tbody>
</table>



</div>
	
	





</body>
</html>
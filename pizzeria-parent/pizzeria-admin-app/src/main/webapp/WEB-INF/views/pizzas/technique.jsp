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


<div class ='container'>
<div class='jumbotron'>


<h2> LA TOP DU TOP MESURE TECHNIQUE</h2>

IL Y A ${nbSession} SESSION(S) OUVERTE(S) !!!!!


<table class= 'table'>
<c:forEach var="temps" items="${tempsReq}" varStatus="status">

<tr>
<td> La requête vers <c:out value="${cheminReq[status.index]}"/> a été éxécuté en  <c:out value="${temps}"/> millisecondes</td>
</tr>
</c:forEach>

</table>



<table class= 'table'>
<c:forEach var="event" items="${ListePizzaEvent}">

<tr>
<td> <c:out value="${event.code}"/> : <c:out value="${event.type}"/>  : <c:out value="${event.heureCreation}"/></td>
</tr>
</c:forEach>

</table>

</div>
</div>


</body>
</html>
<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Liste des utilisateurs</title>
</head>
<body>
	<%-- <% 
	ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>(); 
	liste = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
	%> --%>
	<jsp:include page="/WEB-INF/header.jsp"/>
	
	<c:choose>
	<c:when test="${ empty utilisateurs }">
		<p>Désolé, la liste des utilisateurs est vide ! </p>
	</c:when>
	<c:otherwise>
	<div class="centered-content">
		<h2> Liste des utilisateurs</h2>
	</div>
	
			 <table border="1" class="centered-table">
		        <thead>
		            <tr>
		                <th>Id</th>
		                <th>Prénom</th>
		                <th>Nom</th>
		                <th>Login</th>
		                <th>Password</th>
		                <th colspan="2">Action</th>
		            </tr>
		        </thead>
		        <tbody>
		        		<c:forEach var="utilisateur" items="${utilisateurs}">
		            	<tr>
		            		<td> ${utilisateur.id} </td>
		            		<td> ${utilisateur.prenom} </td>
		            		<td> ${utilisateur.nom}</td>
		            		<td> ${utilisateur.login}</td>
		            		<td> ${utilisateur.password} </td>
		            		<td class="action-column">
			            		<a href="update?id=${utilisateur.id}"> Modifier </a>
		            		</td>
		            		<td class="action-column">
			            		<a href="delete?id=${utilisateur.id}"> Supprimer </a>
		            		</td>	
		            	</tr>
		            	</c:forEach>
		         </tbody>
    		</table>
	</c:otherwise>
	</c:choose>
</body>
<jsp:include page="/WEB-INF/footer.jsp"/>
</html>
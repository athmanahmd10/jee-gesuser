<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="/WEB-INF/header.jsp"/>
	<c:choose>
	<c:when test="${ empty utilisateur }">
		<h2> Ajout d'un utilisateur </h2>
		<form method="post">
	        <label for="name">Nom :</label>
	        <input type="text" id="name" name="name" required><br>
	        
			<label for="firstname">Prénom :</label>
	        <input type="text" id="firstnamename" name="firstname" required><br>
	        
	        <label for="login">Login :</label>
	        <input type="text" id="login" name="login" required><br>
	        
	        <label for="password">Mot de passe :</label>
	        <input type="password" id="password" name="password" required><br>
	
	        <button type="submit">Enregistrer</button>
	  </form>
	</c:when>
	<c:otherwise>
	<h2> Modification d'un utilisateur </h2>
		<form method="post">
			<input type="hidden" id="id" name="id" value="${utilisateur.id}" required ><br>
	        <label for="fistname">Prénom :</label>
	        <input type="text" id="firstname" name="firstname" value="${utilisateur.prenom}" required><br>
	        
			<label for="lastname">Nom :</label>
	        <input type="text" id="lastname" name="lastname" value="${utilisateur.nom}" required><br>
	        
	        <label for="login">Login :</label>
	        <input type="text" id="login" name="login" value="${utilisateur.login}" required><br>
	        
	        <label for="password">Mot de passe :</label>
	        <input type="password" id="password" name="password" value="${utilisateur.password}" required><br>
	
	        <button type="submit">Modifier</button>
	  </form>
	</c:otherwise>
	</c:choose>
	
</body>
<jsp:include page="/WEB-INF/footer.jsp"/>
</html>
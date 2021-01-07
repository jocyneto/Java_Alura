<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="url" />

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Fazendo login</title>
	</head>
	<body>
		<form action="${url}">
			<label for="login">Login</label>
			<input type="text" id="login" name="login"/>
			
			<label for="senha">Senha</label>
			<input type="password" id="senha" name="senha"/>

			<input type="submit" name="acao" value="Login"/>
			
		
		</form>
	</body>
</html>
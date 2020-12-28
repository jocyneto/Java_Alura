<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoMaterial" var="url"/>
<!DOCTYPE html>
	<html>
		<head lang="pt-br">
		<meta charset="UTF-8">
		<title>Casdastro de Material</title>		
		</head>
		
		<body>
			<h2>Cadastrando Material:</h2>
			<form action="${url}" method="post">
				Nome do Material: <input type="text" name="nome"/>
				Quantidade: <input type="text" name="quantidade">
				Data Cadasto: <input type="text" name="dataCadastro">
				<input type="submit" action/>					
			</form>
			
			
		</body>
		
		
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="url"/>
<!DOCTYPE html>
	<html>
		<head lang="pt-br">
		<meta charset="UTF-8">
		<title>Casdastro de Empresa</title>		
		</head>
		
		<body>
			<h2>Cadastrando Empresa:</h2>
			<form action="${url}" method="post">
				Nome do Empresa: <input type="text" name="nome"/>				
				Data Cadasto: <input type="text" name="data">
				<input type="submit" name="acao" value="NovaEmpresa"/>					
			</form>
			
			
		</body>
		
		
</html>
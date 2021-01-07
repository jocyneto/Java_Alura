<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="url"/>
<!DOCTYPE html>
	<html>
		<head lang="pt-br">
		<meta charset="UTF-8">
		<title>Alterando Empresa</title>		
		</head>
		
		<body>
			<h2>Cadastrando Empresa:</h2>
			<form action="${url}" method="post">
				Nome do Empresa: <input type="text" name="nome" value="${empresa.nome}"/>
				<fmt:formatDate value="${empresa.dataAbertura}" var="dataAnterior"/>		
				Data Cadasto: <input type="text" name="data" value="${dataAnterior}">
				<input type="hidden" name="id" value="${empresa.id}"/>
				<input type="hidden" name="acao" value="AlteraEmpresa"/>
				<input type="submit" />					
			</form>
			
			
		</body>
		
		
</html>
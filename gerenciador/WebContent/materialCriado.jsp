<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Cadastro de Material</title>
	</head>
	<body>
		<p>Material ${nomeMaterial} cadastrado com sucesso!</p>
		<fmt:formatDate value="${dataMaterial}" pattern="dd/MM/yyyy" var="dataDeAdicao"/>
		<p>Quantidade adicionado(s): ${quantidadeMaterial}  -- Data de adição: ${dataDeAdicao} </p>
		
		<c:forEach items="${listaMaterial}" var="listaDeMaterial">
			<ul>
				<li>${listaDeMaterial.retorna}</li>
			</ul>
		</c:forEach>	
	</body>
</html>
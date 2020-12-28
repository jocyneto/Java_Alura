<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.modelo.Empresa, java.util.List, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Tag Library</title>
</head>
<body>
	<p>Nova empresa cadastrada: ${ nomeEmpresa }</p> 
	<h3>Lista das empresas cadastradas:</h3>
	<ul>
		<c:forEach items="${empresas}" var="lista" >
			<fmt:formatDate value="${lista.dataAbertura}" pattern="dd/MM/yyyy" var="dataAbetura"/>
			<li>${lista.nome} - ${dataAbetura}</li>
		</c:forEach>
	</ul>	
</body>
</html>
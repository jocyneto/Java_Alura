
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.modelo.Empresa, java.util.List, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Tag Library</title>
</head>
<body>
	<p>Nova empresa cadastrada: ${ empresaEscrita }</p> 
	<h3>Lista das empresas cadastradas:</h3>
	<ul>
		<c:forEach items="${empresas}" var="emp" >
			<li>${emp.nome}</li>
		</c:forEach>
	</ul>	
</body>
</html>
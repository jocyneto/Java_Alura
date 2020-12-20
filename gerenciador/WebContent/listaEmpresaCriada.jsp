<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.modelo.*, java.util.List"%>

<%
	String empresaEnviada = (String)request.getAttribute("empresaEscrita");
	List<Empresa> listaDeEmpresas = (List<Empresa>) request.getAttribute("listasDasEmpresas");
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Nova empresa cadastrada: <%=empresaEnviada %></p> 
	<h3>Lista das empresas cadastradas:</h3>
	<%=listaDeEmpresas.size() %>
</body>
</html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.modelo.Empresa, java.util.List, java.util.ArrayList"%>

<%
	String empresaEnviada = (String)request.getAttribute("empresaEscrita");
	List<Empresa> listaDeEmpresas = (List<Empresa>) request.getAttribute("empresas");
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
	<% for(Empresa empr : listaDeEmpresas){  %>
	<li><%=empr.getNome() %></li>
	<%} %>
</body>
</html>
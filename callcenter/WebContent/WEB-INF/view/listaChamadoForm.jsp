<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="url" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Listando chamados</title>
</head>
<body>
	<ul>
		<c:forEach items="${listaDeChamados }" var="listacmd">
			<fmt:formatDate value="${listacmd.dataAbertura }" pattern="dd/MM/yyyy" var="dataAbertura" />
			<fmt:formatDate value="${listacmd.dataConclusao }" pattern="dd/MM/yyy" var="dataConclusao"/>
			<li>
				${listacmd.nome} - ${listacmd.email} - ${listacmd.telefone} - ${listacmd.servico} - ${listacmd.status} - ${dataAbertura} - ${dataConclusao} - ${listacmd.observacao}
				<a href="/callcenter/entrada?acao=MostraChamado&id=${listacmd.id}">Editar</a>
				<a href="/callcenter/entrada?acao=RemoveChamado&id=${listacmd.id}">Remover</a>  
			</li>
		</c:forEach>
	</ul>
		
</body>
</html>
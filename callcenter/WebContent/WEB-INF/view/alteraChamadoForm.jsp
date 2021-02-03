<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="url"/>
<!DOCTYPE html>
<html>
<head lang="pt-br">
	<title>Criando chamado...</title>
	<meta charset="utf-8">
</head>
<body>
	<form action="${url }" >
		<label for="nome">Nome:</label>
		<input type="text" id="nome" name="nome" value="${chamado.nome}">

		<label for="email">E-mail:</label>
		<input type="text" id="email" name="email" value="${chamado.email}">	
		
		<label for="telefone">Telefone:</label>
		<input type="text" id="telefone" name="telefone" value="${chamado.telefone}">	

		<label for="servico">Serviço:</label>
		<input type="text" id="servico" name="servico" value="${chamado.servico}">

		<fieldset>
			<legend>Status:</legend>
			<select type="text" id="status" name="status" value="${chamado.status}">
				<option>Aberto</option>
				<option>Em andamento</option>
				<option>Finalizado</option>
			</select>
		</fieldset>
		
		<fmt:formatDate value="${chamado.dataAbertura}" var="dataAbetura"/>
		<label for="dataAbertura">Data de abertura:</label>
		<input type="text" id="dataAbertura" name="dataAbertura" value="${dataAbetura }">
		
		<fmt:formatDate value="${chamado.dataConclusao}" var="dataConclusao"/>
		<label for="dataConclusao">Data de conclusao:</label>
		<input type="text" id="dataConclusao" name="dataConclusao" value="${ dataConclusao}">


		<label for="observacao">observacao</label>
		<textarea id="observacao" name="observacao" value="${chamado.observacao}"></textarea>
		
		<input type="hidden" name="id" value="${chamado.id}"/>
		<input type="hidden" name="acao" value="AlteraChamado"/>
		
		<fieldset>
			<input type="submit" >
		</fieldset>
	</form>

</body>
</html>
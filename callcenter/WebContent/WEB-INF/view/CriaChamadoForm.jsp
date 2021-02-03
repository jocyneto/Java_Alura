<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<input type="text" id="nome" name="nome">

		<label for="email">E-mail:</label>
		<input type="text" id="email" name="email">	
		
		<label for="telefone">Telefone:</label>
		<input type="text" id="telefone" name="telefone">	

		<label for="servico">Serviço:</label>
		<input type="text" id="servico" name="servico">

		<fieldset>
			<legend>Status:</legend>
			<select type="text" id="status" name="status">
				<option>Aberto</option>
				<option>Em andamento</option>
				<option>Finalizado</option>
			</select>
		</fieldset>

		<label for="dataAbertura">Data de abertura:</label>
		<input type="text" id="dataAbertura" name="dataAbertura">

		<label for="dataConclusao">Data de conclusao:</label>
		<input type="text" id="dataConclusao" name="dataConclusao">


		<label for="observacao">observacao</label>
		<textarea id="observacao" name="observacao"></textarea>

		<fieldset>
			<input type="submit" name="acao" value="CriaChamado">
		</fieldset>
	</form>


</body>
</html>
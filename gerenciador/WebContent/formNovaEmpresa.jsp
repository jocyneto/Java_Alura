<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="enderecoUrl"/>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta>
		<title>Criando um servlet</title>
	</head>
	<body>
		<form action="${enderecoUrl}" method="post">
			Nova empresa: <input  type="text" name="nome"/>
			Data Abertura: <input  type="text" name="data"/>
			<input type="submit"/>			
		</form>
	</body>
</html>
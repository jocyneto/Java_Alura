<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/listaEmpresa" var="enderecoUrl"/>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta>
		<title>Criando ums servlet</title>
	</head>
	<body>
		<form action="${enderecoUrl}" method="post">
			Nova empresa: <input  type="text" name="nome"/>
			<input type="submit"/>			
		</form>
	</body>
</html>
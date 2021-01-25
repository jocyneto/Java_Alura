<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${url }">
		<label>Cidade Procurada:</label>
		<input type=text name="cidade"/>
		<input type="submit" name="acao" value="ProcuraCidade"/>
	</form>

</body>
</html>
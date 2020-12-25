<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:if test="${not empty empresa }">
			<p>Empresa ${empresa } criada</p>
		</c:if>
		
		<c:if test="${empty empresa }">
			<p>Nehuma empresa criada!</p>
		</c:if>
		 
	</body>
</html>
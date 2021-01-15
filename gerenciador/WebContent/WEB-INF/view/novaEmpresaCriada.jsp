<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<body>
		<c:import url="logout-parte.jsp" />
		<c:if test="${not empty nomeEmpresa }">
			<fmt:formatDate value="${dataEmpresa}" pattern="dd/MM/yyyy" var="dataCriacao"/>
			<p>Empresa ${nomeEmpresa} criada, data de abertura em ${dataCriacao} </p>
		</c:if>
		
		<c:if test="${empty nomeEmpresa }">
			<p>Nehuma empresa criada!</p>
		</c:if>
		 
	</body>
</html>
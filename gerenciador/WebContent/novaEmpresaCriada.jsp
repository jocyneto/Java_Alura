<%
	String novaEmpresa = (String)request.getAttribute("empresa");
	System.out.println(novaEmpresa);
	
%>


<html>
	<body>
		<p>Nova empresa <% out.println(novaEmpresa); %> criada!</p>	
		<p>Nova empresa <%=novaEmpresa %> criada!</p>	
	</body>
</html>
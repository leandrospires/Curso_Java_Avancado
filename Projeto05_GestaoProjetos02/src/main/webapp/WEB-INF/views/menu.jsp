<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Menu de Op��es</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@include file="api_bootstrap.jsp" %>
	
</head>
<body>
	<div class="container">
		<h1>Menu de Op��es</h1>
		<ul>
			<li>
				<a href=<c:url value="/cliente/lista" />>Lista de Clientes</a>
			</li>
		</ul>
	</div>
</body>
</html>
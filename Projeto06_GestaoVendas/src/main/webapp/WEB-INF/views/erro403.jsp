<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Página de Erro</title>
	
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>
	<div class="container">
		<h2>Erro: </h2>
		<div class="alert alert-danger text-center" style="margin-top:50px;">
			Acesso não permitido para este usuário!
		</div>
	</div>
</body>
</html>
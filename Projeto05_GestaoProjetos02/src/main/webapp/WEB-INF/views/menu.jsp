<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Menu de Opções</title>
	<%@include file="api_bootstrap.jsp" %>
	
</head>
<body>

	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		<h1>Menu de Opções</h1>
		<ul>
			<li>
				<a href=<c:url value="/clientes/lista" />>Lista de Clientes</a>
			</li>
			<li>
				<a href=<c:url value="/clientes/listaProjetos" />>Lista de Projetos por Clientes</a>
			</li>			
			<li>
				<a href=<c:url value="/prestadores/lista" />>Lista de Prestadores</a>
			</li>				
			<li>
				<a href=<c:url value="/projetos/cadastro" />>Cadastro de Projetos</a>
			</li>
			<li>
				<a href=<c:url value="/pagamento/cadastro" />>Cadastro de Pagamentos</a>
			</li>
				
		</ul>
	</div>
</body>
</html>
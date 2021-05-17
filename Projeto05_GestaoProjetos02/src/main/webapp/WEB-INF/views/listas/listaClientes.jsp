<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Clientes</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Clientes</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value = "/" /> role="button">Voltar</a>
		</div>		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>E-MAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${listaClientes}">
					<tr>
						<td>${c.id}</td>
						<td>${c.nome}</td>
						<td>${c.email}</td>
						<td>${c.telefone}</td>
						<td>
							<a class="btn btn-primary" href=<c:url value="/projetos/lista/${c.id}"/> role="button">Ver Projetos</a>
						</td>
												
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
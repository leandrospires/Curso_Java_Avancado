<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Projetos por Clientes</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Projetos por Clientes</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value = "/" /> role="button">Voltar</a>
		</div>		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>CLIENTE</th>
					<th>TELEFONE</th>
					<th>QUANTIDADE DE PROJETOS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="qc" items="${listaQuantClientes}">
					<tr>
						<td>${qc.nomeCliente}</td>
						<td>${qc.telefoneCliente}</td>
						<td>${qc.quantidade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Projetos por Cliente</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Projetos: ${nomeCliente}</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value="/clientes/lista" /> role="button">Voltar</a>
		</div>		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>DESCRIÇÃO</th>
					<th>DURAÇÃO</th>
					<th>VALOR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaProjetos}">
					<tr>
						<td>${p.id}</td>
						<td>${p.descricao}</td>
						<td>${p.duracao}</td>
						<td>${p.valor}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
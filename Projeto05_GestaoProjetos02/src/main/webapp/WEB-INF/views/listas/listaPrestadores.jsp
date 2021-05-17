<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Prestadores</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Prestadores</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value = "/" /> role="button">Voltar</a>
		</div>		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>NOME</th>
					<th>E-MAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaPrestadores}">
					<tr>
					
						<td>${p.documento}</td>
						<td>${p.nome}</td>
						<td>${p.email}</td>
						<td>${p.telefone}</td>
						<td> 
							<a class="btn btn-primary" href=<c:url value="/pagamento/lista/${p.documento}"/> role="button">Ver Pagamentos</a>
						</td>
					 						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
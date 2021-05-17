<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Pagamentos</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Pagamentos: ${nomePrestador}</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value="/prestadores/lista" /> role="button">Voltar</a>
		</div>		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>TIPO</th>
					<th>VALOR</th>
					<th>IMPOSTO</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaPagamento}">
					<tr>
					
						<td>${p.id}</td>
						<td>${p.tipo}</td>
						<td><fmt:formatNumber value="${p.valor}" type="currency" /></td>
						<td><fmt:formatNumber value="${p.imposto}" type="currency" /></td>
					 						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
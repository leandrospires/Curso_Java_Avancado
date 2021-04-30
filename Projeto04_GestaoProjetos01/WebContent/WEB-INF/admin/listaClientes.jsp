<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Clientes</title>
	

	
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		<h2>Lista de Clientes</h2>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>E-MAIL</th>
					<th>TELEFONE</th>
				</tr>
				
				<tboby>
					<c:forEach var="cliente" items="${listaClientes}">
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.email}</td>
							<td>${cliente.telefone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</thead>
		</table>
		
		
	</div>

</body>
</html>
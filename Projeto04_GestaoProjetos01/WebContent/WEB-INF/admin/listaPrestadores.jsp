<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Prestadores</title>
	

	
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		
		<h2>Lista de Prestadores</h2>
		<div style="margin: 5px">
			<a class="btn btn-primary" href="cadastro?opcao=p" role="button">Incluir Prestador</a>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>NOME</th>
					<th>E-MAIL</th>
					<th>TELEFONE</th>
				</tr>
				
				<tboby>
					<c:forEach var="prestador" items="${listaPrestadores}">
						<tr>
							<td>${prestador.documento.numero}</td>
							<td>${prestador.nome}</td>
							<td>${prestador.email}</td>
							<td>${prestador.telefone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</thead>
		</table>
		
		
	</div>

</body>
</html>
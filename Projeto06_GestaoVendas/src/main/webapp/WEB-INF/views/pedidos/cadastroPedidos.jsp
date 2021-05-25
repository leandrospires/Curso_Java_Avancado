<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Pedidos por Cliente</title>
	
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>
	<div class="container">
		<h2>Cadastro de Pedidos por Cliente</h2>
		
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadpedido"/> method="post">
				
					<div class="form-group">
						<label for="descricao">Número do Pedido: </label> 
						<input type="text" class="form-control" id="numeroPedido" name="numeroPedido">
					</div>

					<div class="form-group">
						<label for="idcliente">Cliente</label>
						
						<select class="form-control" name="documentoCliente" id="documento">
							<option value="0">-- SELECIONE O CLIENTE --</option>
							<c:forEach var="c" items="${clientes}">
								<c:choose>
									<c:when test="${ndoc eq c.documento }">
										<option value="${c.documento}" selected> ${c.nome}</option>
									</c:when>
									<c:otherwise>
										<option value="${c.documento}"> ${c.nome}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Pedido</button>
				</form>
			</div>
		</div>		
	</div>
	<div class="container" style="padding-top: 50px;">
		<c:choose>
			<c:when test="${pedidos eq null}">
				<div class="alert alert-warning text-center">
					${mensagem}
				</div>
			</c:when>
			<c:otherwise>
				<h3>Lista de Pedidos por cliente</h3>

				<div class="row">
					<div class="col-12">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>PEDIDO</th>
									<th>DATA</th>
									<th>CLIENTE</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pd" items="${pedidos}">
									<tr>
										<td>${pd.pedido}</td>
										<td><fmt:formatDate value="${pd.data}" pattern="dd/MM/yyyy"/>   </td>
										<td>${pd.cliente}</td>
										<td>${pd.documento}</td>
										<td><a href=<c:url value="/itens/gestao?idpedido=${pd.idPedido}"/> >Gestão de Itens</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</c:otherwise>
		</c:choose>


	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#documento').change(function(){
				let doc = $(this).val();
				let url = 'http://localhost:11565/Projeto06_GestaoVendas/pedidos/cadastro'; 
				
				if (doc != '0') {
					url += '?doc=' + doc
				}
				
				$(location).attr('href', url);
				
			});
		});
	</script>
	
</body>
</html>
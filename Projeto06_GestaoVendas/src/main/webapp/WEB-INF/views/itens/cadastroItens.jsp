<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>Cadastro de Pedidos</title>

<%@include file="/WEB-INF/comuns/api_bootstrap.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

</head>
<body>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>
	<div class="container">
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value = "/pedidos/cadastro" /> role="button">Voltar</a>
		</div>			
	
		<div class="row">
			
			<!-- Dados do Cliente -->
			<div class="col-6">
				<h2>Gestão Pedidos</h2>
				<div class="alert alert-primary">
					<h5>Dados do Cliente</h5>
					<strong>CPF......: </strong>${pedidosVM.documento}<br/>
					<strong>Cliente..: </strong>${pedidosVM.cliente}<br/>
					<strong>Pedido...: </strong>${pedidosVM.pedido}<br/>
				</div>
				
				<!-- Inclusão de Itens -->
				<form action=<c:url value="/caditem" /> method="post">
					
					<input type="hidden" name="idPedido" value="${pedidosVM.idPedido}"/>
					
					<div class="form-group">
						<label for="idProduto">Selecione o Produto: </label>
						<select class="form-control" name="idProduto">
							<c:forEach var="p" items = "${produtos}">
								<option value="${p.id}">${p.descricao} </option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="quantidade">Quantidade: </label> 
						<input type="text" class="form-control" id="quantidade" name="quantidade">
					</div>
					
					<button type="submit" class="btn btn-primary">Incluir Item</button>
					
				</form>				
				
			</div>	

			
			<div class="col-6">
				<h2>Itens do Pedido</h2>
				<table class="table table-sm" id="tabela">
					<thead>
						<tr>
							<th>PRODUTO</th>
							<th>QUANTIDADE</th>
							<th>VALOR TOTAL</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pi" items="${produtosItensVM}">
							<tr>
								<td>${pi.descricao}</td>
								<td>${pi.quantidade}</td>
								<td id="valorTotal"><fmt:formatNumber value="${pi.valorTotal}" type="currency" /></td>
								<td>
									<span class="badge badge-danger">
									<a href=<c:url value="/itens/remocao/?id=${pi.idItens}&idPedido=${pi.idPedido}" /> >X</a>
									</span>
								</td>					
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="table-warning">
							<th scope="row">Valor Total do Pedido:</th>
							<th></th>
							<th><fmt:formatNumber value="${valorTotalPedido}" type="currency" /></th>
							<th></th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>

</html>


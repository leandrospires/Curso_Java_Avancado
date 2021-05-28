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
			<hr/>
			<div class="col-6" style="padding-top: 25px;">
				<div class="alert alert-primary">
					<h2>EFETUAR PAGAMENTO</h2>
					<label for="cartao">Cartão de Crédito:</label>
					
					<input type="text" class="form-control" id="cartao" name="cartao"/>
					
					<br/>
					<input type="hidden" id="pedido" name="pedido" value="${pedidosVM.pedido}" />
					<input type="hidden" id="valor" name="valor" value="${valorTotalPedido}"/>
					
					<button class="btn btn-primary" type="button" id="efetuarpagamento">Efetuar pagamento</button>
					
					<div id="resposta"></div>
				</div>
				
			</div>
			
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#efetuarpagamento').click(function(){
				//var ctx = "${pageContext.request.contextPath}";
				$.ajax({
					dataType: 'json',
					contentType: 'application/json',
					url: 'http://localhost:8080/Projeto07_ApiPagamentos/api/pagamentos',
					method: 'POST',
					data: JSON.stringify({
						numeropedido: $("#pedido").val(),
						numerocartao: $("#cartao").val(),
						valor: $("#valor").val(),
						status: 1
					}),
					
					success: function(resposta) {
						$('#resposta').html('Pagamento efetuado com sucesso!');
					},
					
					error: function(erro) {
						alert('Erro: ' + erro.responseText);
					}
				});
				
			});
		});
	</script>
	
</body>

</html>


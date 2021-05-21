<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Produtos</title>
	
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
</head>
<body>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Produtos</h2>
		
		<div style="margin: 5px">
			<a class="btn btn-primary" href=<c:url value = "/" /> role="button">Voltar</a>
		</div>		
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DESCRICAO</th>
					<th>UNIDADE</th>
					<th>PRECO</th>
					<th>IMAGEM</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produtos}">
					<tr>
						<td>${p.descricao}</td>
						<td>${p.unidade}</td>
						<td><fmt:formatNumber value="${p.preco}" type="currency" /></td>
						<td>
							<img src= <c:url value = "/imagem/${p.id}"/> width="50px"/>			
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- Modal começa aqui -->
	<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						
					</button>
				</div>
				<div class="modal-body">
					<h4>Confirma exclusão do cliente:</h4>
					<div id="conteudo"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"	data-dismiss="modal">Não, voltar para lista</button>
					<button type="button" id="btnRemover" class="btn btn-danger" data-dismiss="modal">Sim, remover</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
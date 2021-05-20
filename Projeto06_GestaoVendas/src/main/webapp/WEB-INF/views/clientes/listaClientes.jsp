<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Lista de Clientes</title>
	
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>
	<div class="container">
		<h2>Lista de Clientes</h2>
		
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
				<c:forEach var="c" items="${clientes}">
					<tr>
						<td>${c.documento}</td>
						<td>${c.nome}</td>
						<td>${c.email}</td>
						<td>${c.telefone}</td>
						<td>
							<a class="btn btn-primary" href=<c:url value="/clientes/alteracao/${c.documento}"/> role="button">Alterar</a>
							<button data-id="${c.documento}"
									type="button"
									class="btn btn-danger remove"
									data-toggle="modal"
									data-target="#modal">Remover</button>
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

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>
		$(document).ready(function() {

			var id;
			$('.remove').click( function(){
					id = $(this).attr('data-id');
					var texto = "CPF: " + id;
					$("#conteudo").html(texto);
				});
			
			$('#btnRemover').click(function(){
				var url = "http://localhost:11565/Projeto06_GestaoVendas/clientes/remocao/" + id;
				
				$(location).attr('href', url);
			});
			
		});
	</script>
	
</body>
</html>
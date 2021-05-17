<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Projetos</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Cadastro de Projetos por Cliente</h2>
		
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadprojeto"/> method="post">
				
					<div class="form-group">
						<label for="descricao">Descrição: </label> 
						<input type="text" class="form-control" id="descricao" name="descricao">
					</div>
					<div class="form-group">
						<label for="duracao">Duração: </label> 
						<input type="number" class="form-control" id="duracao" name="duracao">
					</div>
					<div class="form-group">
						<label for="valor">Valor: </label> 
						<input type="text" class="form-control phone-mask" id="valor" name="valor">
					</div>

					<div class="form-group">
						<label for="idcliente">Cliente</label>
						<select class="form-control" id="idcliente" name="idcliente">
							<c:forEach var="c" items="${listaClientes}">
								<option value="${c.id}"> ${c.nome}</option>
							</c:forEach>
						</select>
					</div>
					
					<button type="submit" class="btn btn-primary">Incluir Projeto</button>
				
					<c:if test="${resultado ne null }">
						<div class="alert alert-success" role="alert" style="margin-top: 10px;">
						  ${resultado}
						</div>				
					</c:if>
					
				</form>

			</div>
		</div>		
		
	</div>
</body>
</html>
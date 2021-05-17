<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Pagamentos</title>
	
	<%@include file="/WEB-INF/views/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
	<div class="container">
		<h2>Cadastro de Pagamentos por Fornecedores</h2>
		
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadpagamento"/> method="post">
				
					<div class="form-group">
						<label for="prestador">Prestador (Documento / Nome):</label>
						<select class="form-control" id="prestador" name="doc">
							<c:forEach var="p" items="${listaPrestadores}">
								<option value="${p.documento}"> ${p.documento} / ${p.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="tipo">Tipo: </label>
						<select class="form-control" id="tipo" name="tipo_p">
					  		<option value="Projeto">Projeto</option>
					  		<option value="Hora">Hora</option>
						</select>
					</div>
					
					<div class="form-group">
						<label for="valor">Valor: </label> 
						<input type="text" class="form-control" id="valor" name="valor">
					</div>
					<div class="form-group">
						<label for="imposto">Imposto: </label> 
						<input type="text" class="form-control phone-mask" id="imposto" name="imposto">
					</div>
					
					<button type="submit" class="btn btn-primary">Incluir Pagamento</button>
				
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
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Produtos</title>
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>

	<div class="container">
		<div class="row">
			<div class="row-6">
				<h2>Cadastro de Produtos</h2>
				
				<form:form action="/Projeto06_GestaoVendas/cadprodutos" method="post" modelAttribute="produto" enctype="multipart/form-data">
					<div class="form-group">
						<form:label path="descricao">Descricao:</form:label>
						<form:input path="descricao" cssClass="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="unidade">Unidade:</form:label>
						<form:input path="unidade" cssClass="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="preco">Preco:</form:label>
						<form:input path="preco" cssClass="form-control" />
					</div>
					
					<div class="form-group">
						<form:label path="categoria">Categoria:</form:label>
						<form:select path="categoria" cssClass="form-control">
							<form:option value="0">--- SELECIONE ---</form:option>
							<form:options items="${categorias}" itemValue="id" itemLabel="descricao"/>
						</form:select>
					</div>
					
					<div class="form-group">
						<label >Imagem:</label>
						<input type="file" name="foto" class="form-control" />
					</div>					
					
					<button type="submit" class="btn btn-primary">Incluir Produto</button>
												
				</form:form>
			</div>
			
		</div>
	</div>
	
</body>
</html>

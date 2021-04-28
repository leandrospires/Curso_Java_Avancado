<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title></title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		<h2>Cadastro de Clientes</h2>

		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
				
					<input type="hidden" name="opcao" value="c">
				
					<div class="form-group">
						<label for="txtNome">Nome: </label> 
						<input type="text" class="form-control" id="txtNome" name="txtNome">
					</div>
					<div class="form-group">
						<label for="txtEmail">Email: </label> 
						<input type="email" class="form-control" id="txtEmail" name="txtEmail" aria-describedby="emailHelp" placeholder="nome@exemplo.com">
						<small id="emailHelp" class="form-text text-muted">Digite seu e-mail.</small>
					</div>
					<div class="form-group">
						<label for="txtTelefone">Telefone: </label> 
						<input type="text" class="form-control" id="txtTelefone" name="txtTelefone">
					</div>
					<button type="submit" class="btn btn-primary">Incluir Clientes</button>
				
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
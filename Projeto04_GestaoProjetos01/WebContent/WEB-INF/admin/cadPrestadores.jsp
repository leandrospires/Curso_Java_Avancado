<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">

<title>Cadastro de Prestadores</title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp"%>

	<div class="container">
		<h2>Cadastro de Prestadores</h2>

		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
				
					<input type="hidden" name="opcao" value="p">
				
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="optDoc" id="optCpf" value="optCpf">
						<label class="form-check-label" for="optCpf">CPF</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="optDoc" id="optCnpj" value="optCnpj">
						<label class="form-check-label" for="optCnpj">CNPJ</label>
					</div>
				
				
				
					<div class="form-group">
						<label for="txtDocumento">Documento: </label> 
						<input type="text" class="form-control" id="txtDocumento" name="txtDocumento">
					</div>
					
					<div class="form-group">
						<label for="txtUsuario">Usuario: </label> 
						<input type="text" class="form-control" id="txtNome" name="txtUsuario">
					</div>
				
					<div class="form-group">
						<label for="txtSenha">Senha: </label>
						<input type="password" class="form-control" id="txtSenha" name="txtSenha">
					</div>
					
					<div class="form-group">
						<label for="txtnome">Nome: </label> 
						<input type="text" class="form-control" id="txtnome" name="txtnome">
					</div>
					
					<div class="form-group">
						<label for="txtEmail">Email: </label> 
						<input type="email" class="form-control" id="txtEmail" name="txtEmail" aria-describedby="emailHelp" placeholder="nome@exemplo.com">
						<small id="emailHelp" class="form-text text-muted">Digite seu e-mail.</small>
					</div>
					
					<div class="form-group">
						<label for="txtTelefone">Telefone: </label> 
						<input type="text" class="form-control phone-mask" id="txtTelefone" name="txtTelefone" placeholder="(00) 0000-0000">
					</div>

					
					<button type="submit" class="btn btn-primary">Incluir Prestador</button>
				
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
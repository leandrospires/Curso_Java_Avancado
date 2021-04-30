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
		<h2>Cadastro de Usuários</h2>

		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
				
					<input type="hidden" name="opcao" value="u">
				
					<div class="form-group">
						<label for="txtNome">Matrícula: </label> 
						<input type="text" class="form-control" id="txtNome" name="txtNome">
					</div>

					<div class="form-group">
						<label for="txtSenha">Senha: </label>
						<input type="password" class="form-control" id="txtSenha" name="txtSenha">
					</div>

					<div class="form-group">
						<label for="txtNivel">Nível</label>
						<select class="form-control" id="cmbNivel" name="cmbNivel">
							<option value="ADM">ADMINISTRADOR</option>
							<option value="CLIENTE">CLIENTE</option>
							<option value="PREST">PRESTADOR</option>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Incluir Usuário</button>
				
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
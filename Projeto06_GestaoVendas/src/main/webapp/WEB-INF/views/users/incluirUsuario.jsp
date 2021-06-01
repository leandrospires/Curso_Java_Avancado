<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Usuários</title>
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-3">
				<h3>Cadastro de Usuário</h3>
				<form action=<c:url value="/users/cadusuario" /> method="post">
				
					<div class="form-group">
						<label>Usuário:</label>
						<input class="form-control" type="text" name="login">
					</div>				

					<div class="form-group">
						<label>Senha:</label>
						<input class="form-control" type="password" name="password">
					</div>				
				
					<button type="submit" class="btn btn-primary">Incluir Usuário</button>
				</form>
				
				<div>${mensagem}</div>			
			</div>
		</div>
	</div>	
</body>
	
</body>
</html>

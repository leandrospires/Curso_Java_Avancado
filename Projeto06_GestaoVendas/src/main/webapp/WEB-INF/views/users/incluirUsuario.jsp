<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Cadastro de Usu�rios</title>
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
	<a class="navbar-brand" href=<c:url value="/" />>Gest�o de Vendas</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
</nav>


<body>	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<h1>Cadastro de Usu�rios</h1>
				<form action=<c:url value="/users/cadusuario" /> method="post">
				
					<div class="form-group">
						<label>Usu�rio:</label>
						<input class="form-control" type="text" name="login">
					</div>				

					<div class="form-group">
						<label>Senha:</label>
						<input class="form-control" type="password" name="password">
					</div>				
				
					<button type="submit" class="btn btn-primary">Incluir Usu�rio</button>
				</form>
				
				<div>${mensagem}</div>			
			</div>
		</div>
	</div>	
</body>
	
</body>
</html>

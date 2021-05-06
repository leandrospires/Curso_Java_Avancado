<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title></title>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@include file="/WEB-INF/admin/api_bootstrap.jsp" %>
	
</head>
<body>
	
	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">Gestão de Projetos</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
		</ul>
	</div>
</nav>	
	
	<div class="container">
		<h1>Bem vindos ao sistema de Gestão de Projetos</h1>
		<div class="row">
			<div class="col-6">
				<form action="login" method="post">
					<div class="form-group">
						<label for="txtNome">Matrícula: </label> 
						<input type="text" class="form-control" id="txtNome" name="txtNome">
					</div>

					<div class="form-group">
						<label for="txtSenha">Senha: </label>
						<input type="password" class="form-control" id="txtSenha" name="txtSenha">
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
				
					<c:if test="${resultado ne null }">
						<div class="alert alert-danger" role="alert" style="margin-top: 10px;">
						  ${resultado}
						</div>				
					</c:if>
				</form>
			</div>
		</div>		
	</div>
</body>
</html>
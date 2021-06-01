<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Login</title>
<!-- 	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" > -->
<!-- 	<link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" /> -->
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
		<a class="navbar-brand" href=<c:url value="/"/> >Gestão de Vendas</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href=<c:url value = "/users/cadastro" />>Cadastro de Usuário</a></li>
		</ul>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="col-3">	
				<form class="form-signin" method="post"	action="/Projeto06_GestaoVendas/users/login">
					<h2 class="form-signin-heading">Efetue o login:</h2>
					<p>
						<label for="username" class="sr-only">Usuário</label> 
						<input type="text" id="username" name="username" class="form-control" placeholder="Usuário" required autofocus>
					</p>
					<p>
						<label for="password" class="sr-only">Senha</label>
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
					</p>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
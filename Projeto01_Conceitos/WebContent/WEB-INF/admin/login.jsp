<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/principal.css">	

	<title>Login</title>
	
</head>
<body>
	<div>
		<a href="index.jsp">Página Principal</a>
	</div>

	<form action="login" method="post">
		<div class="grupo">
			<label for="txtUsuario">Usuário: </label>
			<input id = "txtUsuario" type="text" name="txtUsuario">
		</div> </br>
		<div class="grupo">
			<label for ="txtSenha">Senha: </label>
			<input id = "txtSenha" type="password" name="txtSenha">
		</div> </br>
		
		<button id="enviar">Enviar</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/principal.css">	
	
	<title>Cadastro de Funcionários - JSP</title>
</head>
<body>

	<section class="container">
		
		<h1>Dados do Funcionário</h1>
		<form action="employee" method="post">
			<div class="grupo">
				<label for="txtNome">Nome: </label>
				<input id ="txtNome" type="text" name="txtNome">
			</div> </br>
			
			<div class="grupo">
				<label for="txtDataNasc">Data Nasc.:</label>
				<input id ="txtDataNasc" type="date" name="txtDataNasc">
			</div> </br>
			
			<div class="grupo">
				<label for="txtCargo">Cargo: </label>
				<input id ="txtCargo" type="text" name="txtCargo">
			</div> </br>		
			
			<div class="grupo">
				<label for="txtSalario">Salario: </label>
				<input id ="txtSalario" type="text" name="txtSalario">
			</div> </br>
			
			<button id="enviar">Cadastrar</button>
			
		</form>
	</section>

</body>
</html>
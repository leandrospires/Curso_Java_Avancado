<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/principal.css">		
<title>Cadastro de Funcionários</title>
</head>
<body>
	<section class="container">
		<h2>Funcionário cadastrado com sucesso!</h2>

		<form>
			<div class="grupo">
				<label for="txtNome">Nome: ${func.nome} </label>
			</div> </br>
			
			<div class="grupo">
				<label for="txtDataNasc">Data Nasc.: ${func.dataNascimento}</label>
			</div> </br>
			
			<div class="grupo">
				<label for="txtCargo">Cargo: ${func.cargo}</label>
			</div> </br>		
			
			<div class="grupo">
				<label for="txtSalario">Salario: ${func.salario}</label>
			</div> </br>
			
			<div class="grupo">
				<label for="txtIrpf">IRPF: ${func.irpf}</label>
			</div> </br>
			
			<div class="grupo">
				<label for="txtSalarioLiq">Salario Liquido: ${func.salarioLiquido}</label>
			</div>
		</form>		
	</section>
</body>
</html>
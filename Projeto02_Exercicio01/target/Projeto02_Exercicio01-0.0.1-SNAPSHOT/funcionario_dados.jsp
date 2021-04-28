<%@page import="br.com.projeto.classes.Funcionario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

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

	<!-- scriptlet --> 
	<% 
		if( request.getMethod().equals("GET") ) {
			
	%>

	<section class="container">
		<div class="espaço">ok</div>
		
		<h1>Dados do Funcionário</h1>
		<form action="" method="post">
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
	
	
	<% } else { 
	
		String nome = request.getParameter("txtNome");
		String datanasc = request.getParameter("txtDataNasc");
		
		Date dataNasc = new SimpleDateFormat("yyy-MM-dd").parse(datanasc);
		
		String cargo = request.getParameter("txtCargo");
		
		double salario = Double.parseDouble(request.getParameter("txtSalario"));
		
		Funcionario f = new Funcionario(nome, dataNasc, cargo, salario);
		
		//Apresentando dados do Funcionário
		out.print("<section class='container'>");
		out.print("<h2> Dados do funcionário - JSP </h2>");
	%>
		
			<form>
				<div class="grupo">
					<label for="txtNome">Nome: <%= nome %> </label>
				</div> </br>
				
				<div class="grupo">
					<label for="txtDataNasc">Data Nasc.: <%= dataNasc %></label>
				</div> </br>
				
				<div class="grupo">
					<label for="txtCargo">Cargo: <%= cargo %></label>
				</div> </br>		
				
				<div class="grupo">
					<label for="txtSalario">Salario: <%= salario %> </label>
				</div> </br>
				
				<div class="grupo">
					<label for="txtIrpf">IRPF: <%= f.getIrpf() %></label>
				</div> </br>
				
				<div class="grupo">
					<label for="txtSalarioLiq">Salario Liquido: <%= f.getSalarioLiquido() %> </label>
				</div>
			</form>
		</section>	
	
	<% } %>
	<!-- scriptlet --> 
	
</body>
</html>
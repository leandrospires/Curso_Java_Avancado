<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title></title>
	<%@include file="api_bootstrap.jsp" %>
			
</head>
<body>
	<div class="container">
		<h1>Ilustração do uso do bootstrap</h1>
		
		<div class="row">
			<div class="col-6">

				<form>
				  <div class="form-group">
				    <label for="txtNome">Nome: </label>
				    <input type="text" class="form-control" id="txtNome" aria-describedby="emailHelp">
				  </div>
				  
				  <div class="form-group">
				    <label for="txtDataNasc">Data Nasc.:</label>
				    <input type="date" class="form-control" id="txtDataNasc">
				  </div>
				  
				  <div class="form-group">
				    <label for="txtCargo">Cargo:</label>
				    <input type="text" class="form-control" id="txtCargo">
				  </div>
				  
				  <div class="form-group">
				    <label for="txtSalario">Salario:</label>
				    <input type="text" class="form-control" id="txtSalario">
				  </div>				  
				
				   <button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>

			</div>
		
		</div>
		
	</div>
</body>
</html>
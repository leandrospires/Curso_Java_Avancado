<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<%@include file="api_bootstrap.jsp" %>


<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
	<a class="navbar-brand" href=<c:url value="/" />>Gestão de Vendas</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Cadastros
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href=<c:url value="/clientes/cadastro" />>Cadastro de Clientes</a>
	          <a class="dropdown-item" href=<c:url value="/produtos/cadastro" />>Cadastro de Produtos</a>
	        </div>
	      </li>
	      
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Listas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href=<c:url value="/clientes/lista" /> >Lista de Clientes</a>
	          <a class="dropdown-item" href=<c:url value="/produtos/lista" /> >Lista de Produtos</a>
	        </div>
	      </li>
	      
	      <li class="nav-item"><a class="nav-link" href=<c:url value = "/pedidos/cadastro" />>Gestão de Pedidos</a></li>
	      
	      <li class="nav-item"><a class="nav-link" href=<c:url value = "/users/cadastro" />>Cadastro de Usuários</a></li>
		</ul>
	</div>
</nav>


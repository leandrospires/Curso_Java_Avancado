<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="cadastro">Gest�o de Projetos</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<!-- 
			<li class="nav-item"><a class="nav-link" href="cadastro?opcao=u">Cadastro de Usu�rios</a></li>
			<li class="nav-item"><a class="nav-link" href="cadastro?opcao=c">Cadastro de Clientes</a></li>
			<li class="nav-item"><a class="nav-link" href="cadastro?opcao=p">Cadastro de Prestadores</a></li>
			<li class="nav-item"><a class="nav-link" href="listaClientes">Listar Clientes</a></li>
			<li class="nav-item"><a class="nav-link" href="listaPrestadores">Listar Prestadores</a></li>
			 -->

	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Cadastros
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="cadastro?opcao=u">Cadastro de Usu�rios</a>
	          <a class="dropdown-item" href="cadastro?opcao=c">Cadastro de Clientes</a>
	          <a class="dropdown-item" href="cadastro?opcao=p">Cadastro de Prestadores</a>
	        </div>
	      </li>
	      
	      	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Listas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="listaClientes">Lista de Clientes</a>
	          <a class="dropdown-item" href="listaPrestadores">Lista de Prestadores</a>
	        </div>
	        
	      </li>
		</ul>
	</div>
	<li class="nav-item text-right text-white">
		Ol� ${sessionScope.session_usuario.nome} | <a href=<c:url value="/login" />>Logout</a>
	</li>	
</nav>


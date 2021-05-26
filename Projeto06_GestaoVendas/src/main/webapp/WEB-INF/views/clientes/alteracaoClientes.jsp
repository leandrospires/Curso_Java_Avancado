<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	
	<title>Alteração de Clientes</title>
	<%@include file="/WEB-INF/comuns/api_bootstrap.jsp" %>
	
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@ include file="/WEB-INF/comuns/cabecalho.jsp"%>

	<div class="container">
		<div class="row">
			<div class="row-6">
				<h2>Alteração de Clientes</h2>
				<c:url var="post_url"  value="/alteracliente" />
				<form:form action="${post_url}" method="post" modelAttribute="cliente">
					<div class="form-group">
						<form:label path="documento">Documento:</form:label>
						<form:input path="documento" readonly="true" cssClass="form-control" />
						<form:errors path="documento" cssClass="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="nome">Nome:</form:label>
						<form:input path="nome" cssClass="form-control" />
						<form:errors path="nome" cssClass="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="telefone">Telefone:</form:label>
						<form:input path="telefone" cssClass="form-control" />
						<form:errors path="telefone" cssClass="text-danger"/>
					</div>
					
					<div class="form-group">
						<form:label path="email">E-mail:</form:label>
						<form:input path="email" cssClass="form-control" />
						<form:errors path="email" cssClass="text-danger"/>
					</div>
					
					<button type="submit" class="btn btn-primary">Salvar</button>
												
				</form:form>
			</div>
			
		</div>
	</div>
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/principal.css">	
	<%@include file="api_bootstrap.jsp" %>
	
	<title>Exemplos JSTL</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1> <c:out value="Exemplos de JSTL"></c:out> </h1> <br/>
	
	<c:set var="nome_pessoa" value="${param.nome}" />
	<!-- eq = equals / ne = not equals -->
	
	<c:choose>
		<c:when test="${nome_pessoa ne null}">
			<h2> <c:out value= "${nome_pessoa}" /> </h2>
		</c:when>
		<c:otherwise>
			<h2> <c:out value= "não recebeu o valor" /> </h2>
		</c:otherwise>	
	</c:choose>
	
	<%-- c:if test="${nome_pessoa ne null}"> --%>
	
</body>
</html>
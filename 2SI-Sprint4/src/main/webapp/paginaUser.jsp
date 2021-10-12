<%@page import="br.fiap.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Usuário Awave</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
			<%
			Usuario checkId = (Usuario) request.getAttribute("usuario");
			%>
			<h1 class="dados">
				Olá,
				<%=checkId.getNome()%></h1>

			<h3 class="dados userId" id="userId">
				ID :
				<%=checkId.getId_usuario() %>
			</h3>
			<h3 class="dados userEmail" id="userEmail">
				EMAIL :
				<%=checkId.getEmail() %>
			</h3>

		<form action="alteracadastro" id="alteracadastro" method="post">
			<button type="submit" name="alteraCadastro" class="botao">ALTERAR
				DADOS</button>
		</form>
		<br>

		<form action="nav" id="nav" method="post">
			<button type="submit" name="iniciaNav" class="botao">INICIAR
				NAVEGAÇÃO</button>
		</form>
		<br>
	</div>
</body>
</html>
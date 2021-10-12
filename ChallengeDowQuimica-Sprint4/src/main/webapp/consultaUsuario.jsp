<%@page import="br.fiap.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Usuario</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
		<br>
		<p>CONSULTA DE USUÁRIOS</p>
		<br> <br> <br>
		<form action="administrarusuario" id="administrar" class="formulario" method="post">
			<label for="id"></label> <br> <input type="text" id="idUser"
				class="form_input" name="idUser" placeholder="Confirme o ID do Usuário a ser pesquisado">
			<br> <br>

			<button type="submit" name="consultar" class="botao">CONSULTAR</button>
			<br>
		</form>
	</div>
</body>
</html>
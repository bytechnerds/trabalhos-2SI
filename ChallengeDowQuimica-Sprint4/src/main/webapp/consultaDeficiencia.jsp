<%@page import="br.fiap.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estat�sticas por Defici�ncias</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
		<br>
		<p>ESTAT�STICAS POR DEFICI�NCIAS</p>
		<br> <br> <br>
		<form action="administrardeficiencias" id="administrardeficiencias" class="formulario"
			method="post">
			<select name="deficiencia" id="deficiencia" class="formulario">
				<option value="placeholder" selected>Defici�ncia</option>
				<option value="CEGUEIRA">CEGUEIRA</option>
				<option value="BAIXAVISAO">BAIXA VIS�O</option>
				<option value="DALTONISMO">DALTONISMO</option>
			</select> <br>

			<button type="submit" name="consultar" class="botao">CONSULTAR</button>
			<br>
		</form>
	</div>
</body>
</html>
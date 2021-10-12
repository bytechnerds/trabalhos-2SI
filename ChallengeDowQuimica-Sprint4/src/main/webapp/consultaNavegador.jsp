<%@page import="br.fiap.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estatísticas por Navegadores</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
		<br>
		<p>ESTATÍSTICAS POR NAVEGADORES</p>
		<br> <br> <br>
		<form action="administrarnavegadores" id="administrarnavegadores" class="formulario"
			method="post">
			<select name="navegador" id="navegador"	class="formulario">
					<option value="placeholder" selected>Navegador Padrão</option>
					<option value="CHROME">CHROME</option>
					<option value="FIREFOX">FIREFOX</option>
					<option value="EDGE">EDGE</option>
					<option value="OPERA">OPERA</option>
					<option value="SAFARI">SAFARI</option>
					<option value="BRAVE">BRAVE</option>
					<option value="INTERNETEXPLORER">INTERNETEXPLORER</option>
				</select><br>

			<button type="submit" name="consultar" class="botao">CONSULTAR</button>
			<br>
		</form>
	</div>
</body>
</html>
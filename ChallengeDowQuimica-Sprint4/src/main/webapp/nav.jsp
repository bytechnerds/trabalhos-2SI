<%@page import="br.fiap.entidade.Site"%>
<%@page import="br.fiap.dao.SiteDAO"%>
<%@page import="br.fiap.entidade.Sessao"%>
<%@page import="br.fiap.dao.SessaoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Navegação</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">

		<h1>NAVEGAÇÃO</h1>
		<br>
		<form action="encerranav" id="nav" method="post">
			<div class="campo">
				<p>Digite a url que deseja buscar</p>
				<input name="url" type="text" class="form_input"
					placeholder="exemplo: www.google.com.br">
				<div class="botao">
					<button type="submit" name="encerraNav">NAVEGAR</button>
					
					<p>Ao clicar em NAVEGAR, você passará automaticamente pela navegação e será encaminhado deslogado.</p>
				</div>
			</div>
			<br>
		</form>
	</div>
</body>
</html>
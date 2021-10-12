<%@page import="br.fiap.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Cadastro</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
		<br>
		<p>ALTERAÇÃO DE DADOS CADASTRAIS</p>
		<br> <br> <br>
		<form action="salvar" id="salvar" class="formulario" method="post">
		<label for="id"></label> <br> <input type="text"
				id="idUser" class="form_input" name="idUser"
				placeholder="Confirme seu ID">
				<br>
				<br>
			<label for="email"></label> <br> <input type="text"
				id="novoEmail" class="form_input" name="novoEmail"
				placeholder="Novo Email"> <br> <label for="password"></label>
			<br> <input type="password" id="novaSenha" class="form_input"
				name="novaSenha" placeholder="Nova Senha"> <br> <br>
			<br> <br>
			<p>
				Caso não queira alterar algum campo, <br>apenas deixe-o em
				branco
			</p>


			<button type="submit" name="salvar" class="botao">SALVAR</button>
			<br>
		</form>
	</div>
</body>
</html>
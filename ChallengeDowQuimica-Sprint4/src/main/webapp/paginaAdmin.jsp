<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Página de Administrador</title>
<link rel="stylesheet" href="stylenavadmin.css">
</head>
<body>
	<div class="principal">
		<h1>Painel de Administrador</h1>
		<p>Selecione uma opção</p>

		<div class="botoes">
			<form action="paginaAdmin" id="paginaAdmin" method="post">
				<button type="submit" id="consultarUsuario" name="consultarUsuario">Consultar
					usuário</button>
				<br>
				<button type="submit" id="consultarSessao" name="consultarSessao">Consultar
					sessão</button>
				<br>
				<button type="submit" id="estDeficiencias" name="estDeficiencias">Estatísticas
					deficiências</button>
				<br>
				<button type="submit" id="estNavegadores" name="estNavegadores">Estatísticas
					navegadores</button>
				<br>
				<button type="submit" id="encerrar" name="encerrar">Encerrar</button>
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ações de Voluntariado</title>
<link rel="stylesheet" href="stylecadastro.css">
</head>
<body>
	<div class="principal">
		<h1>participar de um voluntariado</h1>
		<div class="formulario">
			<p>Filtre por tipo de ação</p>
			<div class="botoes">
				<form action="filtraracao" id="filtraracao" method="post">
					<select name="tag" id="tag" class="formulario">
						<option value="placeholder" selected>TAGS</option>
						<option value="CRIANCAS">CRIANÇAS</option>
						<option value="MULHERES">MULHERES</option>
						<option value="FAMILIAS">FAMÍLIAS</option>
						<option value="SEMTETO">PESSOAS EM SITUAÇÃO DE RUA</option>
						<option value="BAIXARENDA">PESSOAS EM SITUAÇÃO DE BAIXA
							RENDA</option>
					</select>

					<div class="botao">
						<button type="submit" value="buscar" form="filtraracao">BUSCAR</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
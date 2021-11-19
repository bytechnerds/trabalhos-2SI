<%@page import="br.fiap.entidade.Voluntario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina de Volunt�rio</title>
<link rel="stylesheet" href="stylenav.css">
</head>
<body>
	<div class="principal">
		<h1>VOLUNT�RIO</h1>
		<%
		Voluntario checkId = (Voluntario) request.getAttribute("usuario");
		%>
		<h2>
			Ol�,
			<%=checkId.getNome()%></h2>

		<h3>
			ID :
			<%=checkId.getId()%>
			- EMAIL :
			<%=checkId.getEmail()%>
		</h3>


		<p>Escolha uma op��o</p>

		<div class="botoes">
			<div class="line">
				<a href="doarDinheiro.html">
					<button type="submit" name="doarDinheiro" class="botao">
						DOAR DINHEIRO</button>
				</a> <a href="doarAlimentos.html">
					<button type="submit" name="doarALimento" class="botao">DOAR
						ALIMENTO</button>
				</a>
			</div>
			<br> <br>
			<div class="line">
				<a href="escolhavoluntariado.jsp">
					<button type="submit" name="participarAcao" class="botao">PARTICIPAR
						DE A��O DE VOLUNTARIADO</button>
				</a>
				<form action="listarcentroscoleta" id="listarcentroscoleta" method="post">
					<button type="submit" name="listarcentroscoleta" class="botao">DESCATAR
						ELETR�NICOS</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
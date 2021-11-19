<%@page import="br.fiap.dao.ParceiroDAO"%>
<%@page import="br.fiap.entidade.Acao"%>
<%@page import="java.util.List"%>
<%@page import="br.fiap.dao.AcaoDAO"%>
<%@page import="br.fiap.entidade.Parceiro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Página de Parceiro</title>
<link rel="stylesheet" href="stylenavparceiro.css">
</head>
<body>
	<div class="principal">
		<h1>PARCEIRO</h1>
		<%
		Parceiro checkId = (Parceiro) request.getAttribute("usuario");

		ParceiroDAO dao = new ParceiroDAO();
		Parceiro user = dao.consultarPorId(checkId.getId());

		request.setAttribute("user", user);
		%>
		<h2>
			Olá,
			<%=checkId.getNome()%></h2>

		<h3>
			ID :
			<%=checkId.getId()%>
			- EMAIL :
			<%=checkId.getEmail()%>
			- CNPJ:
			<%=checkId.getCnpj()%>
		</h3>

		<p>Escolha uma opção</p>

		<div class="botoes">

			<a href="novaAcao.html">
				<button type="submit" id="criarAcao" name="criarAcao">CRIAR
					AÇÕES DE VOLUNTARIADO</button>
			</a> <br>
			<a href="removerAcao.html">
				<button type="submit" id="removerAcao" name="removerAcao">REMOVER
					AÇÕES DE VOLUNTARIADO</button>
			</a> <br> <a href="confirmarIdListagem.html">
				<button type="submit" id="listarAcoes" name="listaracao">LISTAR
					AÇÕES</button>
			</a> <br> <a href="confirmarIdColeta.html">
				<button type="submit" id="habilitarColeta" name="habilitarColeta">HABILITAR
					COLETA DE ELETRÔNICOS</button>
			</a> <br>
		</div>

	</div>
</body>
</html>
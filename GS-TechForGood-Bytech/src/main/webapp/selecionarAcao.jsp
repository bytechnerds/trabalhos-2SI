<%@page import="br.fiap.entidade.Parceiro"%>
<%@page import="br.fiap.entidade.Acao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de Centros de Coleta</title>
<link rel="stylesheet" href="styleoutputs.css">
</head>
<body>
	<h1 class="outputLista">Lista de Centros de Coleta!</h1>
	<br>
	<br>
	<form action="inscrevervoluntario" id="inscrevervoluntario"
		method="post">
		<%
		List<Acao> lista = (List<Acao>) request.getAttribute("lista");
		for (Acao acao : lista) {
		%>
		<div class="card">
			<input type="radio" value="<%=acao.getId()%>" name="escolha"
				class="dado">
			<tr>
				<td class="dado">Título: <%=acao.getTitulo()%></td>
				<br>
				<td class="dado">Descrição: <%=acao.getDescricao()%></td>
				<br>
				<td class="dado">Duração: <%=acao.getDuracao()%></td>
				<br>
				<td class="dado">Inscritos: <%=acao.getInscritos()%></td>
				<br>
				<td class="dado">Categoria: #<%=acao.getTipoTag()%></td>
			</tr>
		</div>
		<%
		}
		%>
		<div class="botao">
			<button type="submit" value="doardinheiro">INSCREVER-SE</button>
		</div>
	</form>
</body>
</html>
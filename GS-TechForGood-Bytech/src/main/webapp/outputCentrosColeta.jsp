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
	<%
	List<Parceiro> lista = (List<Parceiro>) request.getAttribute("lista");
	for (Parceiro parceiro: lista) {
	%>
	<div class="card">
		<tr>
			<td class="dado">Nome: <%=parceiro.getNome()%></td>
			<br>
			<td class="dado">CNPJ: <%=parceiro.getCnpj()%></td>
			<br>
			<td class="dado">Endereço: <%=parceiro.getEndereco()%></td>
		</tr>
	</div>
	<%
	}
	%>
</body>
</html>
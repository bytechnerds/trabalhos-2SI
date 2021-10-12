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
		<%
		SessaoDAO sessao = new SessaoDAO();
		Sessao s = new Sessao(0, null, 0, null, 0, 0);

		SiteDAO site = new SiteDAO();
		Site p = new Site(0, null, 0);
		
		int cont = 0, cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0, cont7 = 0;		

		s.setId_sessao();
		int id_sessao = s.getId_sessao();
		s.setData_acesso();
		s.setDuracao();
		%>

		<h1>NAVEGAÇÃO</h1>
		<br>
		<form action="nav" id="nav" method="post">
			<div class="campo">
				<p>Digite a url que deseja buscar</p>
				<input name="url" type="text" class="form_input"
					placeholder="exemplo: www.google.com.br">
				<div class="botao">
					<button>
						<%
						String url = request.getParameter("url");
						p.setId_site();
						p.setUri(url);
						p.setNumero_de_acessos(cont++);
						%>
						BUSCAR
					</button>
				</div>
			</div>

			<p>Selecione as funções</p>


			<div class="botoes">
				<button>
					<%
					cont1++;
					%>Descrever página completa
				</button>
				<br>
				<button>
					<%
					cont2++;
					%>Navegar por blocos
				</button>
				<br>
				<button>
					<%
					cont3++;
					%>Navegar por imagens
				</button>
				<br>
				<button>
					<%
					cont4++;
					%>Navegar por midias
				</button>
			</div>

			<div class="botoes-2">
				<br>
				<button>
					<%
					cont5++;
					%>Navegar por botões
				</button>
				<br>
				<button>
					<%
					cont6++;
					%>Navegar por entrada de dados
				</button>
				<br>
				<button>
					<%
					cont7++;
					%>Narrar
				</button>
				<br>

				<button type="submit" name="encerraNav">Encerrar</button>

			</div>
			<%
			site.inserirSite(p);
			
			String contagem = s.contaFuncoes(cont1, cont2, cont3, cont4, cont5, cont6, cont7);
			s.setFuncoes(contagem);
			s.setId_site(p);
			sessao.inserir(s);
			%>
		</form>
	</div>
</body>
</html>
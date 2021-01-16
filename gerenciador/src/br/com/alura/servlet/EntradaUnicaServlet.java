package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.acao.Acao;
import br.com.alura.acao.AlteraEmpresa;
import br.com.alura.acao.CadastroEmpresaForm;
import br.com.alura.acao.ListaEmpresa;
import br.com.alura.acao.MostraEmpresa;
import br.com.alura.acao.NovaEmpresa;
import br.com.alura.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
		if(usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}		
		
		String nomeRequisicao = null;
		
		String nomeClasse = "br.com.alura.acao." + paramAcao;		
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			nomeRequisicao = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] requisicao = nomeRequisicao.split(":");
		if(requisicao[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/"+requisicao[1]);
			rd.forward(request, response);	
		}else {
			response.sendRedirect(requisicao[1]);
		}		
		
				
		/*
		if(paramAcao.equals("ListaEmpresa")) {			
			ListaEmpresa acao = new ListaEmpresa();
			nomeRequisicao = acao.executa(request, response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {			
			RemoveEmpresa acao = new RemoveEmpresa();
			nomeRequisicao = acao.executa(request, response);
			
		} else if(paramAcao.equals("AlteraEmpresa")) {			
			AlteraEmpresa acao = new AlteraEmpresa();
			nomeRequisicao = acao.executa(request, response);
			
		} else if(paramAcao.equals("MostraEmpresa")) {			
			MostraEmpresa acao = new MostraEmpresa();
			nomeRequisicao = acao.executa(request, response);
			
		} else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nomeRequisicao = acao.executa(request, response);
		} else if(paramAcao.equals("CadastroEmpresaForm")) {
			CadastroEmpresaForm acao = new CadastroEmpresaForm();
			nomeRequisicao = acao.executa(request, response);
		}
		*/
		
		
	}

}

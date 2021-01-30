package br.com.jojomaster.servlet;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jojomaster.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("Chamando ControladorFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		String nomeRequisicao = null;

		String nomeClasse = "br.com.jojomaster.acao." + paramAcao;		
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

	}
}

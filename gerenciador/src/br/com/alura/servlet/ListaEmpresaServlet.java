package br.com.alura.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/listaEmpresa")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Instância dos objetos
		BancoSimulado bs = new BancoSimulado();	
		
		//Variaveis
		List<Empresa> lista = lista = bs.getLista();			
		
		//Request dos atributos do servlet para a JSP que irá chamar
		request.setAttribute("empresas", lista);
		
		//chamar jsp
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresaCriada.jsp");
		rd.forward(request, response);		
		
	}

}

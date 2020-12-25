package br.com.alura.modelo;

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

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/listaEmpresa")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresaEnviada;
		String dataEnviada;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura = null;		
		List<Empresa> lista = new ArrayList<>();
		//PrintWriter out;		
		Empresa emp = new Empresa();	
		BancoSimulado bs = new BancoSimulado();		
		
		//out = response.getWriter();
		lista = bs.getLista();
		empresaEnviada = request.getParameter("nome");
		dataEnviada = request.getParameter("data");
		
		try {			
			dataAbertura = sdf.parse(dataEnviada);
		} catch (ParseException e) {			
			throw new ServletException(e);
		}
		
		emp.setNome(empresaEnviada);
		emp.setDataAbertura(dataAbertura);
		bs.adiciona(emp);
		
		
		
		//chamar jsp
		
		request.setAttribute("empresas", lista);
		request.setAttribute("empresaEscrita", empresaEnviada);
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresaCriada.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}

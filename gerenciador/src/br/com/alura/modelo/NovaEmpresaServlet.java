package br.com.alura.modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empresaEnviada;
		
		List<Empresa> listaDeEmpresas = new ArrayList<>();
		PrintWriter out;		
		Empresa empresas = new Empresa();	
		BancoSimulado bs = new BancoSimulado();		
		
		out = resp.getWriter();		
		empresaEnviada = req.getParameter("nome");
		empresas.setNome(empresaEnviada);
		bs.adiciona(empresas);
		listaDeEmpresas = bs.getLista();
		
		out.println("<html><body>");
		out.println("Nova empresa cadastrada: " + empresaEnviada);
		out.println("<h3>Lista das empresas cadastradas:</h3>");
		out.println("<ul>");
		for (Empresa empresa : listaDeEmpresas) {
			out.println("<li>");
			out.print(empresa);
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		
	}

}

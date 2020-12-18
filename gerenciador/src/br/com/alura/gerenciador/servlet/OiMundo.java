package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ola")
public class OiMundo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>OLHA MUNDO MEU PRIMEIRO SERVLET!!!</h1>");
		out.print("<h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h2>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
	
}

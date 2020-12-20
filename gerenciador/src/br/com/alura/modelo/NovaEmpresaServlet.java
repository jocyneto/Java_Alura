package br.com.alura.modelo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa emp = new Empresa();
		BancoSimulado banco = new BancoSimulado();
		String  novaEmpresa= request.getParameter("nome");
		emp.setNome(novaEmpresa);
		banco.adiciona(emp);
		
		//PrintWriter out = resp.getWriter();
		//chamar o JPS
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", emp.getNome());
		rd.forward(request, response);
		
		
	}
}

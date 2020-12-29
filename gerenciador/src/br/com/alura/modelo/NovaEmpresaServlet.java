package br.com.alura.modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Criação dos objetos empresa e "Banco de dados"
		Empresa emp = new Empresa();
		BancoSimulado banco = new BancoSimulado();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Request dos paramentros da pagina web
		String nomeDaEmpresaStr = request.getParameter("nome");
		String dataDaEmpresaStr = request.getParameter("data");
		
		//Transformação dos dados:
		Date dataDaEmpresa;
		try {
			dataDaEmpresa = sdf.parse(dataDaEmpresaStr);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		//Populando os Objetos
		emp.setNome(nomeDaEmpresaStr);
		emp.setDataAbertura(dataDaEmpresa);
		banco.adiciona(emp);
		
		
		//Passar os atributos para meu JPS
		request.setAttribute("nomeEmpresa", emp.getNome());
		request.setAttribute("dataEmpresa", emp.getDataAbertura());
		
		//chamar o JPS	
		response.sendRedirect("listaEmpresa");
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresa");		
//		rd.forward(request, response);
		
		
	}
}

package br.com.alura.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BancoSimulado bs = new BancoSimulado();
		List<Empresa> empresas = bs.getLista();
		
		String requisicao = request.getHeader("Accept");
		
		if (requisicao.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresas", Empresa.class); // Para Transformar o full qualifie name
			String xml = xstream.toXML(empresas);
			
			
			response.setContentType("application/xml");
			PrintWriter pw = response.getWriter();
			pw.println(xml);
		}else if(requisicao.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas); 
			
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.println(json);
		}else {
			response.getWriter().print("{'erro':'request not found'}");
		}
		
		
		
		
		
		
		
	}

}

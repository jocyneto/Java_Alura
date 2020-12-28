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

@WebServlet("/novoMaterial")
public class NovoMaterialServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * @author jocyn
		 * 
		 */
		
		/**
		 * Criando uma "simulação de conexão com o banco"
		 */
		BancoSimulado bs = new BancoSimulado();
		List<Material> lista = new ArrayList<Material>();
		lista = bs.getListaDeMaterial();
		
		/**
		 * Recebendo os atributos do Java Serve Page formCadastroMaterial
		 */
		String nomeDoMaterial = req.getParameter("nome");
		String quantidadeDoMaterialStr = req.getParameter("quantidade");
		String dataCadastroDoMaterialStr = req.getParameter("dataCadastro");
		
		/**
		 *Transformando o atributo quantidade de material em double
		 *, pois somente recebe em String		 * 
		 */
		Double quantidadeDoMaterial = Double.parseDouble(quantidadeDoMaterialStr);
		
		/**
		 *Transformando o atributo Data de cadastro de material em Date
		 *, pois somente recebe em String		 * 
		 */	
		Date dataCadastroDoMaterial;		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataCadastroDoMaterial = sdf.parse(dataCadastroDoMaterialStr);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		/**
		 * Criando o objeto Material e armazenando em uma simulação de banco de dados
		 */
		Material m = new Material(nomeDoMaterial, quantidadeDoMaterial, dataCadastroDoMaterial);
		bs.adiciona(m);
		
		/**
		 * Enviado os atributos para o JSP do Request Dispatcher
		 */
		req.setAttribute("nomeMaterial", nomeDoMaterial);
		req.setAttribute("quantidadeMaterial", quantidadeDoMaterial);
		req.setAttribute("dataMaterial", dataCadastroDoMaterial);
		req.setAttribute("listaMaterial", lista);
		
		RequestDispatcher rd = req.getRequestDispatcher("materialCriado.jsp");
		rd.forward(req, resp);
		
		
		
		
	}
	
	
}

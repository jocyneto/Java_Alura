package br.com.alura.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Empresa;

public class AlteraEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Criação dos objetos empresa e "Banco de dados"
		Empresa empresa;
		BancoSimulado bs = new BancoSimulado();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Request dos paramentros da pagina web
		String nomeDaEmpresaStr = request.getParameter("nome");
		String dataDaEmpresaStr = request.getParameter("data");
		String idStr = request.getParameter("id");
		
		
		//Transformação dos dados:
		Date dataDaEmpresa;
		try {
			dataDaEmpresa = sdf.parse(dataDaEmpresaStr);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Integer id = Integer.valueOf(idStr);
		
		//Alterando os dados do objeto ou Banco
		empresa = bs.buscarEmpresaPorId(id);
		empresa.setDataAbertura(dataDaEmpresa);
		empresa.setNome(nomeDaEmpresaStr);
		
		
		//Passando para frente os dados
		response.sendRedirect("entrada?acao=ListaEmpresa");
	}

	
}

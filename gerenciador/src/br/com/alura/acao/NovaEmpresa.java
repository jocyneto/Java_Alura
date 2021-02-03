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

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Nova empresa");
		
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
		return "redirect:entrada?acao=ListaEmpresa";

	}

}

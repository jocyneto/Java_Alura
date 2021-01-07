package br.com.alura.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Empresa;

public class ListaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando Empresa");
		//Instância dos objetos
		BancoSimulado bs = new BancoSimulado();	
		
		//Variaveis
		List<Empresa> lista = lista = bs.getLista();			
		
		//Request dos atributos do servlet para a JSP que irá chamar
		request.setAttribute("empresas", lista);
		
		//chamar jsp
		return "foward:/listaEmpresaCriada.jsp";
		
	}

}

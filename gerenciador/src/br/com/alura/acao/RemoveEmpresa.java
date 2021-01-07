package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;

public class RemoveEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Removendo Empresa");
		
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		
		
		System.out.println("id removido: "+id);
		
		BancoSimulado bs = new BancoSimulado();
		bs.remove(id);
		
		return "redirect:entrada?acao=ListaEmpresa";		
	}

}

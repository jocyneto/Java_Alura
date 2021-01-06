package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;

public class RemoveEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		
		System.out.println("id removido: "+id);
		
		BancoSimulado bs = new BancoSimulado();
		bs.remove(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresa");		
	}

}

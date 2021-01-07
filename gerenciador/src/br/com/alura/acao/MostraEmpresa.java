package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Empresa;

public class MostraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Mostrando empresa");
		
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		
		BancoSimulado bs = new BancoSimulado();
		
		
		Empresa emp = bs.buscarEmpresaPorId(id);
		
//		System.out.println(emp.getNome());
//		System.out.println(emp.getDataAbertura());
		
		request.setAttribute("empresa", emp);
		
		return "foward:/formAlterarEmpresa.jsp";
		
	}

}

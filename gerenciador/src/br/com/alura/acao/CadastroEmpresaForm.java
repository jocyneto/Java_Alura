package br.com.alura.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroEmpresaForm implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		return "foward:/formCadastroEmpresa.jsp";
	}

}

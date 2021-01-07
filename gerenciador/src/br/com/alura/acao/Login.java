package br.com.alura.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.modelo.BancoSimulado;
import br.com.alura.modelo.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BancoSimulado bs = new BancoSimulado();
		Usuario user = bs.pegaUsuario(login, senha);
		
		System.out.println(user);
		
		if( user != null) {
			return "redirect:entrada?acao=ListaEmpresa";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
		
		
	
	}
}

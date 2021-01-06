package br.com.alura.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.acao.AlteraEmpresa;
import br.com.alura.acao.ListaEmpresa;
import br.com.alura.acao.MostraEmpresa;
import br.com.alura.acao.NovaEmpresa;
import br.com.alura.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class EntradaUnicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresa")) {
			System.out.println("Listando Empresa");
			ListaEmpresa le = new ListaEmpresa();
			le.executa(request, response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {
			System.out.println("Removendo Empresa");
			RemoveEmpresa re = new RemoveEmpresa();
			re.executa(request, response);
			
		} else if(paramAcao.equals("AlteraEmpresa")) {
			System.out.println("Alterando empresa");
			AlteraEmpresa ae = new AlteraEmpresa();
			ae.executa(request, response);
			
		} else if(paramAcao.equals("MostraEmpresa")) {
			System.out.println("Mostrando empresa");
			MostraEmpresa me = new MostraEmpresa();
			me.executa(request, response);
			
		} else if(paramAcao.equals("NovaEmpresa")) {
			System.out.println("Nova empresa");
			NovaEmpresa ne = new NovaEmpresa();
			ne.executa(request, response);
		}
		
	}

}

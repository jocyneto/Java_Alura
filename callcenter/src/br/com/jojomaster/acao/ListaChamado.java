package br.com.jojomaster.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.jojomaster.modelo.BancoDados;
import br.com.jojomaster.modelo.Chamado;

public class ListaChamado implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		BancoDados db = new BancoDados();
		
		List<Chamado> listaDeChamados = db.pegaListaDeChamados();
		
		
		request.setAttribute("listaDeChamados", listaDeChamados);
		
		for (Chamado cha : listaDeChamados) {
			System.out.println(cha);
		}
		
		return "foward:/listaChamadoForm.jsp";
	}

}

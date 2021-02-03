package br.com.jojomaster.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jojomaster.modelo.BancoDados;
import br.com.jojomaster.modelo.Chamado;

public class CriaChamado implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
				
		String paramNome = request.getParameter("nome");
		String paramEmail = request.getParameter("email");
		String paramTelefone = request.getParameter("telefone");
		String paramServico = request.getParameter("servico");
		String paramStatus = request.getParameter("status");
		String paramDataAbertura = request.getParameter("dataAbertura");
		String paramDataConclusao = request.getParameter("dataConclusao");
		String paramObservacao = request.getParameter("observacao");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura;
		Date dataConclusao;
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
			dataConclusao = sdf.parse(paramDataConclusao);			
		}catch(ParseException ex) {
			throw new ServletException(ex);
		}
		
		Chamado chamado = new Chamado();
		chamado.setNome(paramNome);
		chamado.setEmail(paramEmail);
		chamado.setTelefone(paramTelefone);
		chamado.setServico(paramServico);
		chamado.setStatus(paramStatus);
		chamado.setDataAbertura(dataAbertura);
		chamado.setDataConclusao(dataConclusao);
		chamado.setObservacao(paramObservacao);
		
		
		BancoDados db = new BancoDados();
		db.adicionar(chamado);
		
		request.setAttribute("nome", chamado.getNome());
		request.setAttribute("email", chamado.getEmail());
		request.setAttribute("telefone", chamado.getTelefone());
		request.setAttribute("servico", chamado.getServico());
		request.setAttribute("status", chamado.getStatus());
		request.setAttribute("dataAbertura", chamado.getDataAbertura());
		request.setAttribute("dataConclusao", chamado.getDataConclusao());
		request.setAttribute("observacao", chamado.getObservacao());
		
		System.out.println(chamado);
		
		return "redirect:entrada?acao=ListaChamado";
	}

}

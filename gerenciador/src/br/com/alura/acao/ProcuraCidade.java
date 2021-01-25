package br.com.alura.acao;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.fluent.Request;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ProcuraCidade implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String parmCidade = request.getParameter("cidade");
		
		String lugar = parmCidade;
		String lugarEx = lugar.replaceAll(" ", "%20");
		
		String conteudo = Request
			.Post("http://api.weatherstack.com/current?access_key=1177d09c4384cd10f0b3cd87f86f9bd5&query="+lugarEx)
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		
		JSONParser parser = new JSONParser();
		String nomeDaCidade = null;
		try {
			Object obj = parser.parse(conteudo);
			JSONObject jsonObject = (JSONObject)obj;
			nomeDaCidade = (String)jsonObject.get("name");
			
			
		} catch (ParseException ex) {
			throw new ServletException(ex);
		}
		
		
		System.out.println(nomeDaCidade);
		request.setAttribute("cidadeProcurada", nomeDaCidade);
		return "foward:/MostraCidadeForm.jsp";
	}

}

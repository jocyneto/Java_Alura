package br.com.alura.cliente;

import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws Exception{
		/*webservice criado
		String conteudo = Request
			.Post("http://localhost:8080/gerenciador/empresas")
			.addHeader("Accept", "application/xml")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println(conteudo);*/
		
		String lugar = "San Francisco";
		String lugarEx = lugar.replaceAll(" ", "%20");
		
		String conteudo = Request
			.Post("http://api.weatherstack.com/current?access_key=1177d09c4384cd10f0b3cd87f86f9bd5&query="+lugarEx)
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println(conteudo);

	}

}

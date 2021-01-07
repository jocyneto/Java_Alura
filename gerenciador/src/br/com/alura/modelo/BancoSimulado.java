package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoSimulado {
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaDeUsuario = new ArrayList<>();
	private static Integer chaveIntegradora = 1;
	
	static {
		Empresa emp = new Empresa();
		emp.setId(BancoSimulado.chaveIntegradora++);
		emp.setNome("Empresa 1");
		Empresa emp2 = new Empresa();
		emp2.setId(BancoSimulado.chaveIntegradora++);
		emp2.setNome("Empresa 2");
		BancoSimulado.lista.add(emp);
		BancoSimulado.lista.add(emp2);
		
		Usuario adm = new Usuario();
		adm.setLogin("adm");
		adm.setSenha("1234");
		BancoSimulado.listaDeUsuario.add(adm);
		Usuario adm2 = new Usuario();
		adm2.setLogin("jo");
		adm2.setSenha("1234");
		BancoSimulado.listaDeUsuario.add(adm2);
		
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(BancoSimulado.chaveIntegradora++);
		BancoSimulado.lista.add(empresa);
	}
	
	
	
	public List<Empresa> getLista() {
		return BancoSimulado.lista;
	}


	public void remove(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}



	public Usuario pegaUsuario(String login, String senha) {
		for (Usuario user : listaDeUsuario) {
			if (user.ehIgual(login, senha)) {
				return user;
			}
		}
		return null;
	}
	

	
	
}

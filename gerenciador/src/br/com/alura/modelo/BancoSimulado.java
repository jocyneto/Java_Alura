package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.List;

public class BancoSimulado {
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Material> listaDeMaterial = new ArrayList<>();
	
	static {
		Empresa emp = new Empresa();
		emp.setNome("Empresa 1");
		Empresa emp2 = new Empresa();
		emp2.setNome("Empresa 2");
		BancoSimulado.lista.add(emp);
		BancoSimulado.lista.add(emp2);
		
	}
	
	public void adiciona(Empresa empresa) {
		BancoSimulado.lista.add(empresa);
	}
	
	public void adiciona(Material material) {
		BancoSimulado.listaDeMaterial.add(material);
	}
	
	public List<Empresa> getLista() {
		return BancoSimulado.lista;
	}
	
	public List<Material> getListaDeMaterial() {
		return BancoSimulado.listaDeMaterial;
	}
	

	
	
}

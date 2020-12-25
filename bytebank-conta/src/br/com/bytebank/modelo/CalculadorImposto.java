package br.com.bytebank.modelo;

public class CalculadorImposto {
	private double totalImposto;
	
	public double getTotalImposto() {
		return totalImposto;
	}
	
	public void arrecadarImposto(Tributavel t) {
		this.totalImposto += t.getValorImposto();
	}
	
}

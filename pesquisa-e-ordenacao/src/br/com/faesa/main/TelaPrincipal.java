package br.com.faesa.main;

import java.awt.EventQueue;

import br.com.faesa.interfacegrafica.FormPrincipal;


public class TelaPrincipal {
	/**
	 * 
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

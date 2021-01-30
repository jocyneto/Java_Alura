package br.com.jojomaster.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public Connection recuperarConexao() throws SQLException {
		
		System.out.println("Abrindo conexão com banco de dados...");
		return DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/loja_virtual?useTimeZone=true&serverTimezone=UTC"
						, "root"
						, "123456");
	}

}

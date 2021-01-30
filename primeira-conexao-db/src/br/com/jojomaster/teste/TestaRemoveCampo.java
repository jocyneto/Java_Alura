package br.com.jojomaster.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemoveCampo {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasAfetadas = stm.getUpdateCount();//PEGA A QUANTIDADE DE LINHAS AFETADAS NO STATEMENT (COMANDO SQL)
		
		System.out.println("Linhas apagadas: "+linhasAfetadas);
		
		System.out.println("Fechando conexao");
		con.close();
	}

}

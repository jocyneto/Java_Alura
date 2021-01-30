package br.com.jojomaster.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoProduto {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();
		
		String produtoInserido = "Teste";
		String descricaoInserido = "Ninja Bluetooth); DROP TABLE PRODUTO;";
		String inserindoNoBanco = "INSERT INTO PRODUTO (NOME, DESCRICAO)"
								+ "VALUES (?, ?)";//Os paramentros ? serão inserido com o PreparedStatement com o metodo setString, setInteger, etc...
		
		
		
		PreparedStatement stm = con.prepareStatement(inserindoNoBanco, Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, produtoInserido);
		stm.setString(2, descricaoInserido);		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();//PEGA ID GERADO COM Statement.RETURN_GENERATED_KEYS
		
		while(rst.next()) {
			Integer id = rst.getInt(1);//PEGA ID DO getGeneratedKeys()
			System.out.println("ID inserido: " + id);
		}
		
		
		
		
		System.out.println("Fechando conexao.");
		con.close();
	}
}

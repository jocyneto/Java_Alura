
public class TesteConexao {

	public static void main(String[] args) {
		
		try (Conexao con = new Conexao()){//já contem o bloco finally
			con.leDados();
		} catch (IllegalStateException e) {
			System.out.println("Deu errado");
			e.printStackTrace();
		}
		
		
		/*
		Conexao con = null;
		
		try{
			con = new Conexao();
			con.leDados();
			
		} catch(IllegalStateException ex){
			System.out.println("Deu ruim!");
		} finally {
			con.fecha();
		}*/
	}

}

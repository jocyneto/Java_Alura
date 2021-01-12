public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();	
		}catch(NullPointerException | ArithmeticException | MinhaExcecao ex) {
        	System.out.println("deu ruim");
        	ex.printStackTrace();
        }
		
		System.out.println("Fim do main");
	}

	private static void metodo1() throws MinhaExcecao{
		System.out.println("Ini do metodo1");		
		metodo2();		
		System.out.println("Fim do metodo1");
	}/*OU
	
	*private static void metodo1() throws MinhaExcecao{
		System.out.println("Ini do metodo1");
		try {
			metodo2();
		} catch (MinhaExcecao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fim do metodo1");
	}
	*/

	private static void metodo2() throws MinhaExcecao{
		System.out.println("Ini do metodo2");
		/*int z = 10;		
		
		for(int i = 5; i >=0; i--) {
			System.out.println(z/i);
		}*/
		metodo2();

		throw new MinhaExcecao("Deu ruim");

		//System.out.println("Fim do metodo2");        
	}
}
public class Fluxo {

	public static void main(String[] args) {
		System.out.println("Ini do main");
		try {
			metodo1();	
		}catch(NullPointerException | ArithmeticException ex) {
        	System.out.println("E2");
        }
		
		System.out.println("Fim do main");
	}

	private static void metodo1() {
		System.out.println("Ini do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}

	private static void metodo2() {
		System.out.println("Ini do metodo2");
		int z = 10;

		for(int i = 5; i >=0; i--) {
			System.out.println(z/i);
		}



		System.out.println("Fim do metodo2");        
	}
}
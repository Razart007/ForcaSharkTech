package Models;



public class ExemploBoyerMoore {

	private static final String PADRAO = "algo";
	private static final String TEXTO = "analises de algoritmo";

	private char padrao[] = new String(PADRAO).toUpperCase().toCharArray();
	private char texto[] = new String (TEXTO).toUpperCase().toCharArray(); 

	private int m = padrao.length;
	private int n = texto.length;
	private int k = m;
	private int j = n;
	
	public int buscaBoyerMoore(){
		 while (k <= n && j > 1){
			 
			 if(texto[k-(m-j)] == padrao[j]){
				 j--;
			 } else {
				 
				 k = k + (m - seguinte('a'));
				 j = m;
			 }
			 
			 if(j == 0){
				 System.out.println("Esta é a palavra");
			 } else {
				 System.out.println("Não é a palavra");
			 }
		 }
		
		
		return -1;
	}
	
	private int seguinte (char c){
		
		
		
		return -1;		
	}
			
}

package controller;

import view.TelaInicial;
import view.MenuPrincipal;
import view.ShowEnum;

/**
 * @author laboratorio
 * 
 */
public class Sistema {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
		TelaInicial inicio = new TelaInicial();
		ShowEnum show = new ShowEnum();
		int i = 1;
		int j = 1;
		
		inicio.LerArquivo();
		
		while(j != 0)
		{
		
			
			i = show.showEnumMP();
			System.out.println("Variavel i:"+i);
			if(i == -1)
			{
				j = 0;
				System.out.println("Adeus");
			}
		}
		
		inicio.EscreverArquivo();
	}

}

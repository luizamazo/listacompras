package controller;

import view.TelaInicial;
import view.Menu;
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
		int i = 0;
		int j = 1;
		while(j != 0)
		{
			TelaInicial inicio = new TelaInicial();
			Menu menus = new Menu();
			ShowEnum show = new ShowEnum();
			
			i = show.showEnumMP();
			
			if(i == -1)
			{
				j = 0;
				System.out.println("Adeus");
			}
			
			inicio.EscreverArquivo();
			
		}
	}

}

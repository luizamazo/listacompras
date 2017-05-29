package controller;

import java.util.ArrayList;
import java.util.List;

import módulos.Supermercado;
import view.ViewSupermercado;


public class SupermercadoDAO {
	private static List<Supermercado> listadeSupermercados = new ArrayList<Supermercado>();
	Supermercado supermercado = null;
	public void criar() {
		ViewSupermercado vCP = new ViewSupermercado();
		this.supermercado = vCP.showAndSet();
		SupermercadoDAO.listadeSupermercados.add(this.supermercado);
	}
	public Supermercado getLastSupermercado(){
		return this.supermercado;
	}
	/**
	 * @return the listadeProdutos
	 */
	public static List<Supermercado> getListadeSupermercados() {
		return listadeSupermercados;
	}
	/**
	 * @param listadeProdutos the listadeProdutos to set
	 */
	
	public static void setListadeSupermercados(List<Supermercado> listadeSupermercados) {
		SupermercadoDAO.listadeSupermercado = listadeSupermercado;
	}
	
	public void listarSupermercados(){
		for (Supermercado supermercado : listadeSupermercados) {
			supermercardo.show();
		}
	}

}

	
}

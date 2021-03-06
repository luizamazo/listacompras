package view;

import controller.PrecoDAO;
import controller.ProdutoDAO;
import controller.SupermercadoDAO;
import modelo.Preco;

import java.util.Scanner;

public class ViewPreco {
	static Scanner ler = new Scanner(System.in);
	
	//criar o pre�o
	public static Preco criar(int id_cliente) {
		double preco;
		int id_produto, id_supermercado, quantidadeP = 0;
		
		System.out.println("Digite o pre�o: ");
		preco=ler.nextDouble();
		
		quantidadeP = ProdutoDAO.listarProdutos();
		if(quantidadeP != 0)
		{
			System.out.println("Digite o id do produto: ");
			id_produto = ler.nextInt();
			
			while(ProdutoDAO.OKProduto(id_produto)==false) { //verifica se o id � valido
				System.out.println("Id do produto inexistente!\nDigite um id valido");
				id_produto = ler.nextInt();
			}
			quantidadeP = SupermercadoDAO.listar();
			
			if(quantidadeP != 0)
			{
				System.out.println("Id do supermercado.");
				id_supermercado = ler.nextInt();
				
				//verifica o id do supermercado
				
				while(SupermercadoDAO.GetSupermercado(id_supermercado)==null) {
					System.out.println("Id do supermercado inexistente!\nDigite um id valido");
					id_supermercado=ler.nextInt();
				}
					//ja verificou todos os campos
				Preco precoM = PrecoDAO.criarPreco(id_produto, true, id_supermercado, id_cliente, preco);
				if(precoM != null)
				{
					System.out.println("Pre�o ok");
					return precoM;
				}
				else
				{
					System.out.println("Erro pre�o");
					return null;
				}
			}
			else
			{
				System.out.println("N�o existe supermercados cadastrados");
				return null;
			}
		}
		else
		{
			System.out.println("N�o existe produtos");
			return null;
		}
		
	}
	//excluir
	public static void excluir() {
		double preco;
		int id_supermercado, id_produto;
		
		
		System.out.println("Id do supermercado: ");
		SupermercadoDAO.listar();
		id_supermercado = ler.nextInt();
		
		while(SupermercadoDAO.GetSupermercado(id_supermercado)==null) {
			System.out.println("Id do supermercado inexistente!\nDigite um id valido");
			id_supermercado=ler.nextInt();
		}
		
		System.out.println("Digite o id do produto: ");
		ProdutoDAO.listarProdutos();
		id_produto = ler.nextInt();
		
		while(ProdutoDAO.OKProduto(id_produto)==false) { //verifica se o id � valido
			System.out.println("Id do produto inexistente!\nDigite um id valido");
			id_produto = ler.nextInt();
		}
		
		if(PrecoDAO.remover(id_supermercado, id_produto)) {
		System.out.println("Pre�o excluido com sucesso.");
		}else {
			System.out.println("Erro ao excluir pre�o.");
		}
	}
	
	//alterar
	public static void alterar_Preco(){
		double preco;
		int id_supermercado, id_produto;
		
		System.out.println("Novo Pre�o: ");
		preco=ler.nextDouble();
		//falta realizar o controle do pre�o 
		
		System.out.println("Id do supermercado");
		SupermercadoDAO.listar();
		id_supermercado = ler.nextInt();
		
		while(SupermercadoDAO.GetSupermercado(id_supermercado)==null) {
			System.out.println("Id do supermercado inexistente!\nDigite um id valido");
			id_supermercado=ler.nextInt();
		}
		
		System.out.println("Digite o id do produto: ");
		ProdutoDAO.listarProdutos();
		id_produto = ler.nextInt();
		
		while(ProdutoDAO.OKProduto(id_produto)==false) { //verifica se o id � valido
			System.out.println("Id do produto inexistente!\nDigite um id valido");
			id_produto = ler.nextInt();
		}
		
	
		if(PrecoDAO.renomear_preco(id_supermercado, id_produto, preco))
			System.out.println("Pre�o alterado com sucesso...");
		else
			System.out.println("Erro ao alterar preco.");
	}
	//menu
}

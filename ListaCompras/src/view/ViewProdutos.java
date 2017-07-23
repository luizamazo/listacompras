package view;

import java.util.Scanner;

import controller.ProdutoDAO;

public class ViewProdutos {
	static Scanner ler = new Scanner(System.in);
	
	public static void Criar(int id_Cliente)
	{
		String nome, marca;
		System.out.print("Digite o nome do produto: ");
		nome = ler.nextLine();
		System.out.print("Digite a marca do produto: ");
		marca = ler.nextLine();
		
		if(!ProdutoDAO.OKProduto(nome, marca))
		{
			System.out.println("Produto j� existe");
		}
		else
		{
			if(!ProdutoDAO.criar(nome, marca, id_Cliente))
			{
				System.out.println("Erro ao cadastrar produto");
			}
			else
			{
				System.out.println("Produto cadastrado com sucesso!!");
			}
		}
	}
	
	public static void Excluir()
	{
		int id;
		ProdutoDAO.listarProdutos();
		System.out.print("Produto que deve ser excluido: ");
		id = ler.nextInt();
		while(!ProdutoDAO.OKProduto(id))
		{
			System.out.print("N�o existe um produto com esse numero");
			System.out.print("Produto que deve ser excluido: ");
			id = ler.nextInt();
		}
		if(!ProdutoDAO.RemoveProduto(id))
		{
			System.out.print("Erro ao excluir produto");
		}
		else
		{
			System.out.print("Produto excluido com sucesso!!");
		}
	}
	
	public static void Listar()
	{
		ProdutoDAO.listarProdutos();
	}

}

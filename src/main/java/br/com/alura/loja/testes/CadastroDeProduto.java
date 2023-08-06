package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.utils.JPAUtils;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarproduto();

		EntityManager em = JPAUtils.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto prod = produtoDao.buscarPorId(1L);
		System.out.println("produto 1: " + prod.getNome());

		List<Produto> produtos = produtoDao.buscarTodos();
		produtos.forEach(produto ->
			System.out.println("Todos os produtos: " + produto.getNome())
		);

		List<Produto> produtosNome = produtoDao.buscarPorNome("Xiaomi Redmi");
		produtos.forEach(produto ->
				System.out.println("Todos os produtos por nome: " + produto.getNome())
		);

		List<Produto> produtosCateg = produtoDao.buscarPorCategoria("celulares");
		produtos.forEach(produto ->
				System.out.println("Todos os produtos por categoria: " + produto.getNome())
		);
	}

	private static void cadastrarproduto() {
		Categoria celulares = new Categoria("celulares");
		Produto celular = new Produto(
				"Xiaomi Redmi",
				"Muito legal",
				new BigDecimal("800"),
				celulares
		);

		EntityManager em = JPAUtils.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}

}

package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);   //o merge serve para colocar o objeto categoria no estado de "managed" pela JPA, caso ele não esteja nesse estado, o objeto não será atualizado no banco (a entidade sai da condição "managed" quando eu dou close() ou clear(0 na transação, não existe um método PUT na JPA pq, contanto que a entidade esteja no modo "managed", qualquer alteração nela dispara a atualização de forma automática
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto);   //o merge coloca a entidade categoria no estado "managed". Só pode usar o método delete se a entidade estiver "managed"
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";   //essa sintaxe é JPQL, não é SQL
        return em.createQuery(jpql).getResultList(); //getResultList é para disparar o comando no banco
    }
}

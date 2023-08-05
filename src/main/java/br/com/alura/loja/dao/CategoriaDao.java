package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);   //o merge serve para colocar o objeto categoria no estado de "managed" pela JPA, caso ele não esteja nesse estado, o objeto não será atualizado no banco (a entidade sai da condição "managed" quando eu dou close() ou clear(0 na transação, não existe um método PUT na JPA pq, contanto que a entidade esteja no modo "managed", qualquer alteração nela dispara a atualização de forma automática
    }

    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);   //o merge coloca a entidade categoria no estado "managed". Só pode usar o método delete se a entidade estiver "managed"
        this.em.remove(categoria);
    }
}

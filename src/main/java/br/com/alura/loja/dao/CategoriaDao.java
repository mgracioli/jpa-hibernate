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
        this.em.merge(categoria);   //o merge serve para colocar o objeto categoria no estado de "managed" pela JPA, caso ele não esteja nesse estado, o objeto não será atualizado no banco (a entidade sai da condição "managed" quando eu dou close() ou clear(0 na transação
    }
}

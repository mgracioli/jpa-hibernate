package br.com.alura.loja.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    //static para que o manager e o método getEntitymanager sejam criados apenas uma vez (a classe estática não depende do objeto que a instancia, ou seja, essa variável e esse método serão os mesmos para qualquer objeto que instancie essa classe)
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("loja");

    public static EntityManager getEntityManager () {
        return FACTORY.createEntityManager();
    }
}

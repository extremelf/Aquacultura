package com.aquacultura.BLL;

import com.aquacultura.DAL.ClienteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class ClienteBLL {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    public static EntityManagerFactory factory = null;
    public static EntityManager em = null;

    public static void create(ClienteEntity cliente) {
//        if (factory == null) {
//            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        }
//        if (em == null) em = factory.createEntityManager();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(cliente);
        session.getTransaction().commit();
        //em.getTransaction().begin();
        //em.persist(cliente);
        //em.getTransaction().commit();
    }

    public static List<ClienteEntity> readAll() {
        List<ClienteEntity> listaCliente = new ArrayList<>();
//        if (factory == null) {
//            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        }
//        if (em == null) em = factory.createEntityManager();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();


        Query q1 = session.getNamedQuery("Cliente.findAll");
        List result = q1.list();

        for (Object resultado : result) {
            listaCliente.add((ClienteEntity) resultado);
        }

        return listaCliente;
    }

    public static ClienteEntity readById(int idCliente) {
        ClienteEntity cliente;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();


        Query q1 = session.createNamedQuery("Cliente.findById");
        q1.setParameter("idCliente", idCliente);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;
    }

    public static ClienteEntity readByCc(int cc) {
        ClienteEntity cliente;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();


        Query q1 = session.createNamedQuery("Cliente.findByCC");
        q1.setParameter("cc", cc);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;
    }

    public static ClienteEntity readByNome(String nome) {
        ClienteEntity cliente;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();

        Query q1 = session.createNamedQuery("Cliente.findByNome");
        q1.setParameter("nome", nome);

        Object obj = q1.getSingleResult();

        if (obj != null) {
            cliente = ((ClienteEntity) obj);
        } else {
            return null;
        }

        return cliente;

    }

    public static void update(ClienteEntity cliente) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();

        session.getTransaction().begin();
        session.merge(cliente);
        session.getTransaction().commit();
    }

    public static void delete(ClienteEntity cliente) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =sessionFactory.openSession();


        session.getTransaction().begin();
        session.remove(cliente);
        session.getTransaction().commit();
    }

}

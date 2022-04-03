package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Vitima;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VitimaDAO extends AbstractJpaDAO<Vitima> {
    EntityManager entityManager;

    VitimaDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Vitima.class, entityManager);
    }
}

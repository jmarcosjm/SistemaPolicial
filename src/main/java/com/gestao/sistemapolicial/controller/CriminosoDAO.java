package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Criminoso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CriminosoDAO extends AbstractJpaDAO<Criminoso>{

    EntityManager entityManager;

    public CriminosoDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Criminoso.class, entityManager);
    }

}
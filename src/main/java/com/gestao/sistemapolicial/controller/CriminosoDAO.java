package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Criminoso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CriminosoDAO extends AbstractJpaDAO<Criminoso>{



    public CriminosoDAO(EntityManager entityManager){

        setClazz(Criminoso.class, entityManager);
    }

}
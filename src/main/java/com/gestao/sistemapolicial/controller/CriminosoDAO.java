package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CriminosoDAO extends AbstractJpaDAO<Criminoso>{

    EntityManager entityManager;

    public CriminosoDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("crimedao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Criminoso.class, entityManager);
    }

}
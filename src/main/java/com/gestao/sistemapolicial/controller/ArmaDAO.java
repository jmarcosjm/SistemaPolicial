package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Arma;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArmaDAO extends AbstractJpaDAO<Arma>{

    EntityManager entityManager;

    public ArmaDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Arma.class, entityManager);
    }

    public Arma findByNumRegistro(Integer numRegistro){
        try{
            return (Arma) entityManager.createQuery("from " + Arma.class.getName() + " where numero_registro = :numRegistro")
                    .setParameter("numRegistro", numRegistro)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }

}

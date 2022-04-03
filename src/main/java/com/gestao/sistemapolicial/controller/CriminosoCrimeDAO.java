package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.CriminosoCrime;

import javax.persistence.EntityManager;

public class CriminosoCrimeDAO extends AbstractJpaDAO<CriminosoCrime>{

    public CriminosoCrimeDAO(EntityManager entityManager){
        setClazz(CriminosoCrime.class, entityManager);
    }

}

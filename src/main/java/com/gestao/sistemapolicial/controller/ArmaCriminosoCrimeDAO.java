package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.ArmaCriminosoCrime;

import javax.persistence.EntityManager;

public class ArmaCriminosoCrimeDAO extends AbstractJpaDAO<ArmaCriminosoCrime>{

    public ArmaCriminosoCrimeDAO(EntityManager entityManager){
        setClazz(ArmaCriminosoCrime.class, entityManager);
    }
}

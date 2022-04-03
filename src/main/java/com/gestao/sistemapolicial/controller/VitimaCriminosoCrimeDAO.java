package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Arma;
import com.gestao.sistemapolicial.model.entity.VitimaCriminosoCrime;

import javax.persistence.EntityManager;

public class VitimaCriminosoCrimeDAO extends AbstractJpaDAO<VitimaCriminosoCrime>{

    public VitimaCriminosoCrimeDAO(EntityManager entityManager){
        setClazz(VitimaCriminosoCrime.class, entityManager);
    }

}

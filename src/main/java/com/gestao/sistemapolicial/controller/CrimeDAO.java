package com.gestao.sistemapolicial.controller;

import lombok.AllArgsConstructor;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import com.gestao.sistemapolicial.model.entity.Crime;

import java.io.Serializable;

@AllArgsConstructor
public class CrimeDAO <T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz(Class<T> clazzToSet){
        this.clazz = clazzToSet;
    }

    public T findByCpf(String cpf) {
        //return entityManager.createQuery("SELECT t FROM" + clazz.getName() + "WHERE t.");
        return T
    }

    public void insertCrime(Crime crime){
       // return
    }
}

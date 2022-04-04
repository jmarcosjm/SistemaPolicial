package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.CriminosoCrime;

import javax.persistence.EntityManager;
import java.util.List;

public class CriminosoCrimeDAO extends AbstractJpaDAO<CriminosoCrime>{

    public CriminosoCrimeDAO(EntityManager entityManager){
        setClazz(CriminosoCrime.class, entityManager);
    }

    public CriminosoCrime findByCrimeCriminoso(Integer crimeID, Integer criminosoID){
        try{
            return (CriminosoCrime) entityManager.createQuery("select cc from CriminosoCrime cc where cc.idCrime = :crimeID and cc.idCriminoso = :criminosoID")
                    .setParameter("crimeID", crimeID)
                    .setParameter("criminosoID", criminosoID)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }

    }

    public List<CriminosoCrime> findByCrime(Integer crimeID){
        try{
            return entityManager.createQuery("select cc from CriminosoCrime cc where cc.idCrime = :crimeID")
                    .setParameter("crimeID", crimeID)
                    .getResultList();
        }catch (Exception e){
            return null;
        }
    }

}

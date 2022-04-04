package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.VitimaCriminosoCrimeId;
import com.gestao.sistemapolicial.model.entity.CriminosoCrime;
import com.gestao.sistemapolicial.model.entity.VitimaCriminosoCrime;

import javax.persistence.EntityManager;
import java.util.List;

public class VitimaCriminosoCrimeDAO extends AbstractJpaDAO<VitimaCriminosoCrime>{

    public VitimaCriminosoCrimeDAO(EntityManager entityManager){
        setClazz(VitimaCriminosoCrime.class, entityManager);
    }

    public VitimaCriminosoCrime findOne(VitimaCriminosoCrimeId id ){
        return entityManager.find( VitimaCriminosoCrime.class, id );
    }

    public List<VitimaCriminosoCrime> findByCriminosoCrime(CriminosoCrime criminosoCrime){
        try {
            return entityManager.createQuery("select vcc from VitimaCriminosoCrime vcc where vcc.id.idCriminosoCrime = :criminosoCrimeID")
                    .setParameter("criminosoCrimeID", criminosoCrime.getId())
                    .getResultList();
        }catch (Exception e){
            return null;
        }
    }

}

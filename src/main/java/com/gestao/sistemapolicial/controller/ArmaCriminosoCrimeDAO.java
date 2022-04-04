package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.ArmaCriminosoCrimeId;
import com.gestao.sistemapolicial.model.entity.ArmaCriminosoCrime;
import com.gestao.sistemapolicial.model.entity.CriminosoCrime;
import com.gestao.sistemapolicial.model.entity.VitimaCriminosoCrime;

import javax.persistence.EntityManager;
import java.util.List;

public class ArmaCriminosoCrimeDAO extends AbstractJpaDAO<ArmaCriminosoCrime>{

    public ArmaCriminosoCrimeDAO(EntityManager entityManager){
        setClazz(ArmaCriminosoCrime.class, entityManager);
    }

//    public void deleteByArma(Integer armaID){
//        List<ArmaCriminosoCrime> entidades = entityManager.createQuery("select acc from ArmaCriminosoCrime acc where acc.id.idArma = :armaID")
//                .setParameter("armaID", armaID)
//                .getResultList();
//
//        entidades.forEach(armaCriminosoCrime -> {
//            deleteById(armaCriminosoCrime.getId());
//        });
//    }
//
//    public void deleteById( ArmaCriminosoCrimeId entityId ){
//        ArmaCriminosoCrime entity = findOne( entityId );
//        delete( entity );
//    }
//
    public ArmaCriminosoCrime findOne( ArmaCriminosoCrimeId id ){
        return entityManager.find( ArmaCriminosoCrime.class, id );
    }

    public List<ArmaCriminosoCrime> findByCriminosoCrime(CriminosoCrime criminosoCrime){
        try {
            return entityManager.createQuery("select acc from ArmaCriminosoCrime acc where acc.id.idCriminosoCrime = :criminosoCrimeID")
                    .setParameter("criminosoCrimeID", criminosoCrime.getId())
                    .getResultList();
        }catch (Exception e){
            return null;
        }
    }
}

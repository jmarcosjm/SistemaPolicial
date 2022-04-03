package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;



public class CrimeDAO extends AbstractJpaDAO<Crime> {

    EntityManager entityManager;

    public CrimeDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("crimedao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Crime.class, entityManager);
    }

    public void principalFluxo(Crime crime){
        var criminosoDao = new CriminosoDAO();
        var criminosos = crime.getCriminosos();
        var listCriaCriminosos = new ArrayList<Criminoso>();
        var listCriminosos = new ArrayList<Criminoso>();
        criminosos.forEach(criminoso -> {
            Criminoso criminosoReturn = criminosoDao.findByCpf(criminoso.getCpf());
            if(criminosoReturn == null){
                listCriaCriminosos.add(criminoso);
            }else{
                listCriminosos.add(criminosoReturn);
            }
        });
        create(crime);
        for(Criminoso criminoso : listCriaCriminosos){
            criminosoDao.create(criminoso);
            listCriminosos.add(criminoso);
        }
        crime.setCriminosos(listCriminosos);
    }

}

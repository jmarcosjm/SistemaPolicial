package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Arma;
import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import com.gestao.sistemapolicial.model.entity.Vitima;
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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Crime.class, entityManager);
    }

    public void principalFluxo(Crime crime){
        var criminosoDao = new CriminosoDAO();
        var criminosos = crime.getCriminosos();
        var listCriaCriminosos = new ArrayList<Criminoso>();
        var listCriminosos = new ArrayList<Criminoso>();
        var listCriaArmas = new ArrayList<Arma>();
        var listArmas = new ArrayList<Arma>();
        var listCriaVitimas = new ArrayList<Vitima>();
        var listVitimas = new ArrayList<Vitima>();
        criminosos.forEach(criminoso -> {
            Criminoso criminosoReturn = criminosoDao.findByCpf(criminoso.getCpf());
            if(criminosoReturn == null){
                listCriaCriminosos.add(criminoso);
            }else{
                listCriminosos.add(criminosoReturn);
            }
            criminoso.getArmas().forEach(arma -> {

            });
        });
        create(crime);
        for(Criminoso criminoso : listCriaCriminosos){
            criminosoDao.create(criminoso);
            listCriminosos.add(criminoso);
        }
        crime.setCriminosos(listCriminosos);
    }

}

package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Arma;
import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import com.gestao.sistemapolicial.model.entity.Vitima;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class CrimeDAO extends AbstractJpaDAO<Crime> {

    EntityManager entityManager;

    public CrimeDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpadao");
        entityManager = entityManagerFactory.createEntityManager();
        setClazz(Crime.class, entityManager);
    }

    public void principalFluxo(Crime crime){
        var criminosoDao = new CriminosoDAO();
        var armaDao = new ArmaDAO();
        var vitimaDao = new VitimaDAO();

        var criminosos = crime.getCriminosos();
        var listCriaCriminosos = new ArrayList<Criminoso>();
        var listCriminosos = new ArrayList<Criminoso>();

        criminosos.forEach(criminoso -> {
            Criminoso criminosoReturn = criminosoDao.findByCpf(criminoso.getCpf());
            criminosoReturn.setArmas(criminoso.getArmas());
            criminosoReturn.setVitimas(criminoso.getVitimas());
            if(criminosoReturn == null){
                listCriaCriminosos.add(criminoso);
            }else{
                listCriminosos.add(criminosoReturn);
            }
        });
        create(crime);
        for(Criminoso criminoso : listCriaCriminosos){
            try{
                criminosoDao.create(criminoso);
                listCriminosos.add(criminoso);
            }catch (Exception e){
                System.out.println("Erro ao inserir");
            }

        }

        insereArmasVitimas(armaDao, vitimaDao, listCriminosos);

        crime.setCriminosos(listCriminosos);
    }

    private void insereArmasVitimas(ArmaDAO armaDao, VitimaDAO vitimaDao, List<Criminoso> listCriminosos) {
        for(Criminoso criminoso : listCriminosos){
            var listCriaArmas = new ArrayList<Arma>();
            var listArmas = new ArrayList<Arma>();
            var listCriaVitimas = new ArrayList<Vitima>();
            var listVitimas = new ArrayList<Vitima>();

            if(criminoso.getArmas() != null && !criminoso.getArmas().isEmpty()) {

                criminoso.getArmas().forEach(arma -> {
                    Arma armaReturn = armaDao.findByNumRegistro(arma.getNumeroRegistro());
                    if (armaReturn == null) {
                        listCriaArmas.add(arma);
                    } else {
                        listArmas.add(arma);
                    }
                });

            }

            if(criminoso.getVitimas() != null && !criminoso.getVitimas().isEmpty()) {

                criminoso.getVitimas().forEach(vitima -> {
                    Vitima vitimaReturn = vitimaDao.findByCpf(vitima.getCpf());
                    if (vitimaReturn == null) {
                        listCriaVitimas.add(vitima);
                    } else {
                        listVitimas.add(vitima);
                    }
                });

            }

            for(Arma arma : listCriaArmas){
                try{
                    armaDao.create(arma);
                    listArmas.add(arma);
                }catch (Exception e){
                    System.out.println("Erro ao inserir");
                }
            }

            for(Vitima vitima : listCriaVitimas){
                try{
                    vitimaDao.create(vitima);
                    listVitimas.add(vitima);
                }catch (Exception e){
                    System.out.println("Erro ao inserir");
                }
            }
            criminoso.setArmas(listArmas);
            criminoso.setVitimas(listVitimas);

        }
    }

}

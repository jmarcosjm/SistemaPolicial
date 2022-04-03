package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.ArmaCriminosoCrimeId;
import com.gestao.sistemapolicial.model.VitimaCriminosoCrimeId;
import com.gestao.sistemapolicial.model.entity.*;

import javax.persistence.EntityManager;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CrimeDAO extends AbstractJpaDAO<Crime> {


    public CrimeDAO(EntityManager entityManager){
        setClazz(Crime.class, entityManager);
    }

    public void principalFluxo(Crime crime){
        var mapCriminosoArmas = new HashMap<Integer, List<Integer>>();
        var mapCriminosoVitimas = new HashMap<Integer, List<Integer>>();

        var criminosoDao = ConnectionPool.criminosoDAO;
        var armaDao = ConnectionPool.armaDAO;
        var vitimaDao = ConnectionPool.vitimaDAO;

        var criminosos = crime.getCriminosos();
        var listCriaCriminosos = new ArrayList<Criminoso>();
        var listCriminosos = new ArrayList<Criminoso>();

        criminosos.forEach(criminoso -> {
            Criminoso criminosoReturn = criminosoDao.findByCpf(criminoso.getCpf());
            if(criminosoReturn == null){
                listCriaCriminosos.add(criminoso);
            }else{
                criminosoReturn.setArmas(criminoso.getArmas());
                criminosoReturn.setVitimas(criminoso.getVitimas());
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

        listCriminosos.forEach(criminoso -> {
            mapCriminosoArmas.put(criminoso.getId(), criminoso.getArmas()
                    .stream()
                    .map(arma -> arma.getId())
                    .collect(Collectors.toList()));

            mapCriminosoVitimas.put(criminoso.getId(), criminoso.getVitimas()
                    .stream()
                    .map(vitima -> vitima.getId())
                    .collect(Collectors.toList()));
        });

        crime.setCriminosos(listCriminosos);

        constroiRelacoes(crime, criminosoDao, mapCriminosoArmas, mapCriminosoVitimas);
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
                        listArmas.add(armaReturn);
                    }
                });

            }

            if(criminoso.getVitimas() != null && !criminoso.getVitimas().isEmpty()) {

                criminoso.getVitimas().forEach(vitima -> {
                    Vitima vitimaReturn = vitimaDao.findByCpf(vitima.getCpf());
                    if (vitimaReturn == null) {
                        listCriaVitimas.add(vitima);
                    } else {
                        listVitimas.add(vitimaReturn);
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

    private void constroiRelacoes(Crime crime, CriminosoDAO criminosoDAO, HashMap<Integer, List<Integer>> mapCriminosoArmas, HashMap<Integer, List<Integer>> mapCriminosoVitimas){
        var criminosoCrimeDAO = ConnectionPool.criminosoCrimeDAO;
        var armaCriminosoCrimeDAO = ConnectionPool.armaCriminosoCrimeDAO;
        var vitimaCriminosoCrimeDAO = ConnectionPool.vitimaCriminosoCrimeDAO;
        var listCriminosoCrime = new ArrayList<CriminosoCrime>();
        var listCriminoso = new ArrayList<Criminoso>();

        crime.getCriminosos().forEach(criminoso -> {
            var criminosoCrime = CriminosoCrime.builder()
                    .idCriminoso(criminoso.getId())
                    .idCrime(crime.getId())
                    .build();

            listCriminoso.add(criminoso);

            criminosoCrimeDAO.create(criminosoCrime);

            listCriminosoCrime.add(criminosoCrime);
        });

        listCriminosoCrime.forEach(criminosoCrime -> {

            var listArmas = new ArrayList<Integer>();
            var listVitimas = new ArrayList<Integer>();

            for (Criminoso criminoso : listCriminoso) {
                listArmas = (ArrayList<Integer>) mapCriminosoArmas.get(criminoso.getId());
                listVitimas = (ArrayList<Integer>) mapCriminosoVitimas.get(criminoso.getId());


                for (Integer armaId : listArmas) {

                    var armaCriminosoCrimeId = ArmaCriminosoCrimeId.builder()
                            .idCriminosoCrime(criminosoCrime.getId())
                            .idArma(armaId)
                            .build();

                    var armaCriminosoCrime = ArmaCriminosoCrime.builder()
                            .id(armaCriminosoCrimeId)
                            .build();

                    armaCriminosoCrimeDAO.create(armaCriminosoCrime);
                }

                for (Integer vitimaId : listVitimas) {

                    var vitimaCriminosoCrimeId = VitimaCriminosoCrimeId.builder()
                            .idCriminosoCrime(criminosoCrime.getId())
                            .idVitima(vitimaId)
                            .build();

                    var vitimaCriminosoCrime = VitimaCriminosoCrime.builder()
                            .id(vitimaCriminosoCrimeId)
                            .build();

                    vitimaCriminosoCrimeDAO.create(vitimaCriminosoCrime);
                }
            }

        });
    }

}

package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Crime;
import com.gestao.sistemapolicial.model.entity.Criminoso;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Builder
@Repository
public class CrimeDAO extends AbstractJpaDAO<Crime> {

    public CrimeDAO(){
        setClazz(Crime.class);
    }

    public void principalFluxo(Crime crime){
        var crimeDao = CrimeDAO.builder().build();

        var criminosoDao = CriminosoDAO.builder().build();
        var criminosos = crime.getCriminosos();
        var listCriaCriminosos = new ArrayList<Criminoso>();

        criminosos.stream().forEach(criminoso -> {
            if(criminosoDao.findByCpf(criminoso.getCpf()) != null){
                listCriaCriminosos.add(criminoso);
            }
        });

        crimeDao.create(crime);
    }

}

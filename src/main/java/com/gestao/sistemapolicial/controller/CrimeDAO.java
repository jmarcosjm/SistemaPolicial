package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Crime;
import org.springframework.stereotype.Repository;

@Repository
public class CrimeDAO extends AbstractJpaDAO<Crime> {

    public CrimeDAO(){
        setClazz(Crime.class);
    }

}

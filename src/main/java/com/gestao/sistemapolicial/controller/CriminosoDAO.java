package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Criminoso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;


@Repository
@Builder
public class CriminosoDAO extends AbstractJpaDAO<Criminoso>{

    public CriminosoDAO(){
        setClazz(Criminoso.class);
    }

}
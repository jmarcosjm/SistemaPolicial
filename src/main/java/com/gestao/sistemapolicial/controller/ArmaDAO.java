package com.gestao.sistemapolicial.controller;

import com.gestao.sistemapolicial.model.entity.Arma;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Builder
@Service
public class ArmaDAO extends AbstractJpaDAO<Arma>{

    public ArmaDAO(){
        //setClazz(Arma.class);
    }

}

package com.gestao.sistemapolicial.enums;

import lombok.Builder;

public enum TipoArma {

    BRANCA("BRANCA"),
    FOGO("FOGO");

    private final String titulo;
    TipoArma(String titulo){
        this.titulo = titulo;
    }
}

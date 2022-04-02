package com.gestao.sistemapolicial.enums;

public enum TipoArma {

    BRANCA("BRANCA"),
    FOGO("FOGO");




    private final String titulo;
    TipoArma(String titulo){
        this.titulo = titulo;
    }
}

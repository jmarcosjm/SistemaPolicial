package com.gestao.sistemapolicial.model;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode

public class VitimaCriminosoCrimeId implements Serializable {
    private Integer idVitima;
    private Integer idCriminosoCrime;
}

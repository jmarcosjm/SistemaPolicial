package com.gestao.sistemapolicial.model;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ArmaCriminosoCrimeId implements Serializable {
    private Integer idArma;
    private Integer idCriminosoCrime;
}

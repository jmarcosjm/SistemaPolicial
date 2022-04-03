package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.model.ArmaCriminosoCrimeId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_arma_criminoso_crime", schema = "sistema_policial")
public class ArmaCriminosoCrime implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idArma", column = @Column(name = "id_arma")),
            @AttributeOverride(name = "idCriminosoCrime", column = @Column(name = "id_criminoso_crime"))
    })
    private ArmaCriminosoCrimeId id;
}

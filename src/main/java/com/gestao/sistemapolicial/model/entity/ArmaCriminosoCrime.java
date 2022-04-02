package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.model.ArmaCriminosoCrimeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_arma_criminoso_crime")
public class ArmaCriminosoCrime {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idArma", column = @Column(name = "id_arma")),
            @AttributeOverride(name = "idCriminosoCrime", column = @Column(name = "id_criminoso_crime"))
    })
    private ArmaCriminosoCrimeId id;
}

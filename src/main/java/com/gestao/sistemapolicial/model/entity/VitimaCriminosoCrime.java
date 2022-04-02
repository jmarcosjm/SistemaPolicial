package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.model.VitimaCriminosoCrimeId;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_vitima_criminoso_crime")
public class VitimaCriminosoCrime {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idVitima", column = @Column(name = "id_vitima")),
            @AttributeOverride(name = "idCriminosoCrime", column = @Column(name = "id_criminoso_crime") )
    })
    private VitimaCriminosoCrimeId id;
}

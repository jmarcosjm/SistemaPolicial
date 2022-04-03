package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.model.VitimaCriminosoCrimeId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_vitima_criminoso_crime", schema = "sistema_policial")
public class VitimaCriminosoCrime implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idVitima", column = @Column(name = "id_vitima")),
            @AttributeOverride(name = "idCriminosoCrime", column = @Column(name = "id_criminoso_crime") )
    })
    private VitimaCriminosoCrimeId id;
}

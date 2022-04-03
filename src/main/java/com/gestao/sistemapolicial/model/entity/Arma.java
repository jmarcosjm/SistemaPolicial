package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.enums.TipoArma;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_arma")
public class Arma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_registro")
    @NonNull
    private Integer numeroRegistro;

    @Column(name = "tipo")
    @NonNull
    private TipoArma tipoArma;

    @Column(name = "descricao")
    private String descricao;
}

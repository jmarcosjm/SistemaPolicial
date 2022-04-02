package com.gestao.sistemapolicial.model.entity;

import com.gestao.sistemapolicial.enums.TipoArma;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_arma")
public class Arma {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_registro")
    @NonNull
    private Integer numeroRegistro;

    @Column(name = "tipo")
    @NonNull
    private TipoArma tipoArma;

    @Column(name = "descricao")
    @NonNull
    private String descricao;
}

package com.gestao.sistemapolicial.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vitima", schema = "sistema_policial")
public class Vitima implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private String cpf;

    @Column
    @NonNull
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}

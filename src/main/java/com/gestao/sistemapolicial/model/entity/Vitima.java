package com.gestao.sistemapolicial.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vitima", schema = "sistema_policial")
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;

    @Column
    @NonNull
    private String cpf;

    @Column
    @NonNull
    private String nome;

    @Column(name = "data_nascimento")
    @NonNull
    private LocalDate dataNascimento;

}

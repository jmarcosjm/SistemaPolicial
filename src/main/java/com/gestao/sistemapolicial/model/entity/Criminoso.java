package com.gestao.sistemapolicial.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_criminoso", schema = "sistema_policial")
public class Criminoso {

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

    @Transient
    private List<Arma> armas;

    @Transient
    private List<Vitima> vitimas;
}

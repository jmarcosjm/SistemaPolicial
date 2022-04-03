package com.gestao.sistemapolicial.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_criminoso", schema = "sistema_policial")
public class Criminoso implements Serializable {

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
    @NonNull
    private LocalDate dataNascimento;

    @Transient
    private List<Arma> armas;

    @Transient
    private List<Vitima> vitimas;
}

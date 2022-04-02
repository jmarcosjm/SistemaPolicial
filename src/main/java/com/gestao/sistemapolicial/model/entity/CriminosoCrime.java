package com.gestao.sistemapolicial.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_criminoso_crime")
public class CriminosoCrime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_criminoso")
    private Integer idCriminoso;

    @Column(name = "id_crime")
    private Integer idCrime;
}

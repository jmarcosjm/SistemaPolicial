package com.gestao.sistemapolicial.model.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_crime", schema = "sistema_policial")
public class Crime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String descricao;

    @Transient
    private List<Criminoso> criminosos;

    @Transient
    boolean isUpdate;
}

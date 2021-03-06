package com.rd.projetospring.primeiroprojeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "TB_UF")
@Data
public class UfEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UF")
    private BigInteger idUf;

    @Column(name = "DS_UF")
    private String dsUf;

    //relacionamento Bi-direcional
    @OneToMany(mappedBy = "uf")
    private List<CidadeEntity> cidades;

    //Relacionamento uni-direcional. Da UF para Cidade
//    @OneToMany
//    @JoinColumn(name = "ID_UF")
//    private List<CidadeEntity> cidades;
}

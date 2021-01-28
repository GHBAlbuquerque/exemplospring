package com.rd.projetospring.primeiroprojeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_CIDADE")
@Data
public class CidadeEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_CIDADE")
    private BigInteger idCidade;

    @Column(name = "DS_CIDADE")
    private String dsCidade;

    @Column(name = "CD_CIDADE_IBGE")
    private BigInteger cdCidadeIbge;

    //relacionamento Bi-direcional
    @ManyToOne
    @JoinColumn(name = "ID_UF")
    @JsonIgnore
    private UfEntity uf;

    // Relacionamento unidirecional da UF para CIDADE posso comentar o trecho abaixo
//    @ManyToOne
//    @JoinColumn(name = "ID_UF")
//    @JsonIgnore
//    private UfEntity uf;
}

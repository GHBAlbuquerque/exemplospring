package com.rd.projetospring.primeiroprojeto.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_TIPO_USUARIO")
public class TipoUsuarioEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_TIPO_USUARIO")
    private BigInteger idTipoUsuario;

    @Column(name = "DS_TIPO_USUARIO")
    private String dsTipoUsuario;
}

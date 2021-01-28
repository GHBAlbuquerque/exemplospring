package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "TB_USUARIO")
@Data
public class UsuarioEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="ID_USUARIO")
    private BigInteger idUsuario;

//    @Column(name = "ID_GENERO")
//    private BigInteger idGenero;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private GeneroEntity genero;

    @Column(name="ID_ESP_MED")
    private BigInteger idEspMed;

    @Column(name="ID_UF_CRM")
    private BigInteger idUfCrm;

//    @Column(name="ID_TIPO_USUARIO")
//    private BigInteger idTipoUsuario;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_USUARIO")
    private TipoUsuarioEntity tipoUsuario;

    @Column(name="NM_NOME")
    private String nome;

    @Column(name="DT_NASCIMENTO")
    private Date dtNascimento;

    @Column(name="NR_CPF")
    private String cpf;


}
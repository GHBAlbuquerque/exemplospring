package com.rd.projetospring.primeiroprojeto.dto;


import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{

    private Long id;

    private String nome;

    private String cpf;

    private Date dtNascimento;

}

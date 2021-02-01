package com.rd.projetospring.primeiroprojeto.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{

    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dtNascimento;

    private List<Endereco> enderecos;

    private String email;

}

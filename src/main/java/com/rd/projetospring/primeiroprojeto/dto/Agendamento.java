package com.rd.projetospring.primeiroprojeto.dto;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Agendamento {

    private BigInteger idPaciente;
    private BigInteger idAgenda;
    private Date dtSolicitacao;
    private BigInteger idTipoConfirmacao;
    private BigInteger idStatusConsulta;

    private Pagamento pagamento;
}

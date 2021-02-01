package com.rd.projetospring.primeiroprojeto.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagamento {

    private BigInteger idFormaPagto;
    private Date dtPagamento;
    private BigInteger nrParcelas;



}

package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.entity.CidadeEntity;
import com.rd.projetospring.primeiroprojeto.entity.UfEntity;
import com.rd.projetospring.primeiroprojeto.repository.CidadeRepository;
import com.rd.projetospring.primeiroprojeto.repository.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CidadeController {


    @Autowired
    private UfRepository ufRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/uf/{codigoUf}")
    public UfEntity buscarUf(@PathVariable("codigoUf") BigInteger uf){
        return ufRepository.findById(uf).get();
    }

    @GetMapping("/cidade/{codigoCidade}")
    public CidadeEntity buscarCidade(@PathVariable("codigoCidade") BigInteger id){
        return cidadeRepository.findById(id).get();
    }
}

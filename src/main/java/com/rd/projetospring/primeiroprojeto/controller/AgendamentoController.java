package com.rd.projetospring.primeiroprojeto.controller;

import com.rd.projetospring.primeiroprojeto.dto.Agendamento;
import com.rd.projetospring.primeiroprojeto.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgendamentoController {

//    @Autowired
//    private AgendamentoService service;

//    @PostMapping("/agendamento")
//    public ResponseEntity cadastrarAgendamento(Agendamento agendamento){
//        //TODO
//
//        System.out.println(agendamento.getIdAgenda());
//        System.out.println(agendamento.getIdPaciente());
//
////        return ResponseEntity.ok(service.cadastrar(agendamento));
//    }
}

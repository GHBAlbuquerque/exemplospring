package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class AgendamentoService {

//    @Autowired
//    AgendamentoRepository agendamentoRepository;
//
//    @Autowired
//    PagamentoRepository pagamentoRepository;
//
//    public String cadastrar(Agendamento agendamento){
//        AgendamentoEntity agendamentoEntity = new AgendamentoEntity();
//        agendamentoEntity.setIdPaciente(agendamento.getIdPaciente());
//        //TODO implementar....
//
//        AgendamentoEntity agendamentoEntity1 = agendamentoRepository.save(agendamentoEntity);
//
//        @Autowired
//        AgendamentoRepository agendamentoRepository;
//
//        @Autowired
//        PagamentoRepository pagamentoRepository;
//
//        @Transactional
//        public String cadastrar(Agendamento agendamento){
//            AgendamentoEntity agendamentoEntity = new AgendamentoEntity();
//            agendamentoEntity.setIdPaciente(agendamento.getIdPaciente());
//            //TODO implementar....
//
//            AgendamentoEntity agendamentoEntity1 = agendamentoRepository.save(agendamentoEntity);
//
//
//
//            PagamentoEntity pagamentoEntity = new PagamentoEntity();
//            pagamentoEntity.setIdFormaPagto(agendamento.getPagamento().getIdFormaPagto());
//            pagamentoEntity.setIdAgendamento(agendamentoEntity1.getIdAgendamento());
//            //TODO implementar...
//
//            pagamentoRepository.save(pagamentoEntity);
//
//            return "Agendamento realizado";
//        }
//        PagamentoEntity pagamentoEntity = new PagamentoEntity();
//        pagamentoEntity.setIdFormaPagto(agendamento.getPagamento().getIdFormaPagto());
//        pagamentoEntity.setIdAgendamento(agendamentoEntity1.getIdAgendamento());
//        //TODO implementar...
//
//        pagamentoRepository.save(pagamentoEntity);
//
//        return "Agendamento realizado";
//    }
}

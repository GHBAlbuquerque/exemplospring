package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity getUsuario(BigInteger id){
        System.out.println("ID: " + id);
        Optional<UsuarioEntity> optional = repository.findById(id);
        return optional.get();

//        return repository.findById(id).get();

//        Usuario usuario = new Usuario();
//        usuario.setId(entity.getIdUsuario().longValue());
//        usuario.setNome(entity.getNome());
//        usuario.setCpf(entity.getCpf());
//        usuario.setDtNascimento(entity.getDtNascimento());

//        return usuario;
    }

    public List<UsuarioEntity> getUsuarios(Long id){
       return repository.findAll();
    }

    public String excluir (Long id){
        System.out.println("ID: " + id);

        return "Exclusão do ID " + id + " foi realizado com sucesso";
    }

    public String alterar(Usuario usuario, Long id){
        // TODO

        System.out.println("ID: " + id);

        System.out.println(usuario.getId());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getDtNascimento());

        return "Alteração realizado com sucesso";
    }

    public String cadastrar(Usuario usuario){

        System.out.println(usuario.getId() + " . " + usuario.getNome() + " . " + usuario.getCpf() + " . " + usuario.getDtNascimento());

        return "Usuário cadastrado com sucesso";
    }
}

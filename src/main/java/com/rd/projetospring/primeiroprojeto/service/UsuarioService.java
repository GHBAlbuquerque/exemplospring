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
        UsuarioEntity entity = optional.get();

        return entity;

//        return repository.findById(id).get()  ;

//        Usuario usuario = new Usuario();
//        usuario.setId(entity.getIdUsuario().longValue());
//        usuario.setNome(entity.getNome());
//        usuario.setCpf(entity.getCpf());
//        usuario.setDtNascimento(entity.getDtNascimento());

//        return usuario;
    }

    public List<UsuarioEntity> getUsuarios(){
       return repository.findAll();
    }

    public String excluir (BigInteger id){
        System.out.println("ID: " + id);
        repository.deleteById(id);

        return "Exclusão do ID " + id + " foi realizado com sucesso";
    }

    public String alterar(Usuario usuario, BigInteger id){

        UsuarioEntity entity = getUsuario(id);

        entity.setNome(usuario.getNome());
        entity.setCpf(usuario.getCpf());

        entity = repository.save(entity);

//        System.out.println("ID: " + id);
//
//        System.out.println(usuario.getId());
//        System.out.println(usuario.getNome());
//        System.out.println(usuario.getCpf());
//        System.out.println(usuario.getDtNascimento());

        return "Alteração realizado com sucesso";
    }

    public String cadastrar(Usuario usuario){
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome(usuario.getNome());
        entity.setCpf(usuario.getCpf());
//        entity.setIdGenero(BigInteger.valueOf(1));

        repository.save(entity);

        System.out.println(usuario.getId() + " . " + usuario.getNome() + " . " + usuario.getCpf() + " . " + usuario.getDtNascimento());

        return "Usuário cadastrado com sucesso";
    }
}

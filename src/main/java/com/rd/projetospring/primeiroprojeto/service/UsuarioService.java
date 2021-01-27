package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    public Usuario getUsuario(Long id){
        System.out.println("ID: " + id);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Fabio");
        usuario.setCpf("4572938759024");
        usuario.setDtNascimento(new Date());

        return usuario;
    }

    public List<Usuario> getUsuarios(Long id){
        System.out.println("ID: " + id);

        List<Usuario> usuarios = new ArrayList<>();

        if(id == null) {
            Usuario usuario = new Usuario();
            usuario.setId(1L);
            usuario.setNome("Fabio");
            usuario.setCpf("4572938759024");
            usuario.setDtNascimento(new Date());

            usuarios.add(usuario);
        }

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("Ivo");
        usuario2.setCpf("94894054890");
        usuario2.setDtNascimento(new Date());
        usuarios.add(usuario2);

        return usuarios;
    }

    public void cadastrar (Usuario u){

    }
}

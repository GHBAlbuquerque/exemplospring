package com.rd.projetospring.primeiroprojeto.controller;


import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario/{id}")
    public ResponseEntity getUsuario(@PathVariable("id") Long id){
        Usuario usuario = service.getUsuario(id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(usuario);
    }

    @GetMapping("/usuario")
    public ResponseEntity getUsuarios(@PathParam("id") Long id){
        List<Usuario> usuarios = service.getUsuarios(id);
//        return ResponseEntity.ok(usuarios);
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
//        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/usuario")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario){
        if(usuario.getNome() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atributo nome é obrigatório");

        System.out.println(usuario.getId() + " . " + usuario.getNome() + " . " + usuario.getCpf() + " . " + usuario.getDtNascimento());

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");

//        return "Cadastro realizado com sucesso";
    }

    @PutMapping("/usuario/{idUsuario}")
    public String alterar(@RequestBody Usuario usuario, @PathVariable("idUsuario") Long id){
        // TODO

        System.out.println("ID: " + id);

        System.out.println(usuario.getId());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getDtNascimento());

        return "Alteração realizado com sucesso";
    }

    @DeleteMapping("/usuario/{id}")
    public String excluir(@PathVariable("id") Long id){
        System.out.println("ID: " + id);

        return "Exclusão do ID " + id + " foi realizado com sucesso";
    }

}

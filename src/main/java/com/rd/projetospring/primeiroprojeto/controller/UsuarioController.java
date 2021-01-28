package com.rd.projetospring.primeiroprojeto.controller;


import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario/{id}")
    public ResponseEntity getUsuario(@PathVariable("id") BigInteger id){
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.getUsuario(id));
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

        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(usuario));

    }

    @PutMapping("/usuario/{idUsuario}")
    public ResponseEntity alterar(@RequestBody Usuario usuario, @PathVariable("idUsuario") Long id){
        return ResponseEntity.ok().body(service.alterar(usuario, id));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário");
        }
    }

}

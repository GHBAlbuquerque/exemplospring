package com.rd.projetospring.primeiroprojeto.controller;


import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Consulta usuário por id")
    public ResponseEntity getUsuario(@PathVariable("id") BigInteger id){
        return ResponseEntity.status(HttpStatus.OK)
                             .body(service.getUsuario(id));
    }

    @GetMapping("/usuario")
    @ApiOperation(value = "Lista todos usuários")
    public ResponseEntity getUsuarios(@PathParam("id") Long id){
        List<Usuario> usuarios = service.getUsuarios();
//        return ResponseEntity.ok(usuarios);
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
//        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping("/usuario")
    @ApiOperation(value = "Cadastra usuário")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario){
//        if(usuario.getNome() == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atributo nome é obrigatório");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        for (ConstraintViolation<Usuario> violation : violations) {
           return ResponseEntity.status(HttpStatus.CREATED).body(violation.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(usuario));

    }

    @PutMapping("/usuario/{idUsuario}")
    public ResponseEntity alterar(@RequestBody Usuario usuario, @PathVariable("idUsuario") BigInteger id){
        String retorno = service.alterar(usuario, id);
        return ResponseEntity.ok().body(retorno);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity excluir(@PathVariable("id") BigInteger id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário");
        }
    }

    @GetMapping("/usuario/{cpf}")
    public ResponseEntity getUsuario(@PathVariable("cpf") String cpf){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.consultarPorCpf(cpf));
    }
}

package com.rd.projetospring.primeiroprojeto.service;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.rd.projetospring.primeiroprojeto.dto.Endereco;
import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.entity.EnderecoEntity;
import com.rd.projetospring.primeiroprojeto.entity.GeneroEntity;
import com.rd.projetospring.primeiroprojeto.entity.TipoUsuarioEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.repository.GeneroRepository;
import com.rd.projetospring.primeiroprojeto.repository.TipoUsuarioRepository;
import com.rd.projetospring.primeiroprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

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

    public List<UsuarioEntity> getUsuarios2(){

        return repository.findAll();
    }

    public List<Usuario> getUsuarios(){

        List<UsuarioEntity> usuariosEntities = repository.findAll();

        return converterEntityToDTO(usuariosEntities);
    }

    public List<UsuarioEntity> consultarPorNome(String nome){
        return repository.findByNome(nome);
    }

    public String excluir (BigInteger id){
        System.out.println("ID: " + id);
        repository.deleteById(id);

        return "Exclusão do ID " + id + " foi realizado com sucesso";
    }

    @Transactional
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

    @Transactional
    public String cadastrar(Usuario usuario){
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome(usuario.getNome());
        entity.setCpf(usuario.getCpf());

        GeneroEntity genero = generoRepository.findById(BigInteger.valueOf(1)).get();
        entity.setGenero(genero);

        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity(); /// tipoUsuarioRepository.findById(BigInteger.valueOf(usuario.getIdTipoUsuario())).get();
        entity.setTipoUsuario(tipoUsuarioEntity);

        List<EnderecoEntity> enderecosEntity = new ArrayList<>();
        for(Endereco endereco : usuario.getEnderecos()){
            EnderecoEntity enderecoEntity = new EnderecoEntity();
            enderecoEntity.setDsEndereco(endereco.getDsEndereco());
            enderecoEntity.setDsBairro(endereco.getDsBairro());
            enderecoEntity.setNrCep(endereco.getNrCep());
            enderecoEntity.setIdCidade(endereco.getIdCidade());

            enderecosEntity.add(enderecoEntity);

//            enderecoEntity.setUsuario(entity);
        }

        entity.setEnderecos(enderecosEntity);

        repository.save(entity);

        System.out.println(usuario.getId() + " . " + usuario.getNome() + " . " + usuario.getCpf() + " . " + usuario.getDtNascimento());

        return "Usuário cadastrado com sucesso";
    }

    public List<Usuario> consultarPorCpf(String cpf){
        List<UsuarioEntity> listaUsuario = repository.findByCpf(cpf);

        return converterEntityToDTO(listaUsuario);
    }

    private List<Usuario> converterEntityToDTO(List<UsuarioEntity> usuarioEntities){
        List<Usuario> usuariosDTO = new ArrayList<>();

        for(UsuarioEntity usuarioEntity : usuarioEntities){
            Usuario usuarioDTO = new Usuario();
            usuarioDTO.setId(usuarioEntity.getIdUsuario().longValue());
            usuarioDTO.setNome(usuarioEntity.getNome());
            usuarioDTO.setCpf(usuarioEntity.getCpf());
            usuarioDTO.setDtNascimento(usuarioEntity.getDtNascimento());

            List<EnderecoEntity> enderecosEntity = usuarioEntity.getEnderecos();

            List<Endereco> enderecosDTO = new ArrayList<>();

            for(EnderecoEntity enderecoEntity : enderecosEntity){
                Endereco endereco = new Endereco();
                endereco.setIdEndereco(enderecoEntity.getIdEndereco());
                endereco.setDsEndereco(enderecoEntity.getDsEndereco());
                endereco.setDsBairro(enderecoEntity.getDsBairro());
                endereco.setNrCep(enderecoEntity.getNrCep());

                enderecosDTO.add(endereco);
            }

            usuarioDTO.setEnderecos(enderecosDTO);

            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;
    }
}

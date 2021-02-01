package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.entity.LoginUsuarioEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.repository.LoginUsuarioRepository;
import com.rd.projetospring.primeiroprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private LoginUsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<LoginUsuarioEntity> usuario = repository.findByDsEmail(email);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }
}

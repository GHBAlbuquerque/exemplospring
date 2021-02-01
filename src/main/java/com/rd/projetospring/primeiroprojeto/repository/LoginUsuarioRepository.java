package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.LoginUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface LoginUsuarioRepository extends JpaRepository<LoginUsuarioEntity, BigInteger> {

    Optional<LoginUsuarioEntity> findByDsEmail(String email);

}

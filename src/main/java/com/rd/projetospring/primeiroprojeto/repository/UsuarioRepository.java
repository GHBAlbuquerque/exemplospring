package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger> {

}

package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.GeneroEntity;
import com.rd.projetospring.primeiroprojeto.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, BigInteger> {


}

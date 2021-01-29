package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.GeneroEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface GeneroRepository extends JpaRepository<GeneroEntity, BigInteger> {


}

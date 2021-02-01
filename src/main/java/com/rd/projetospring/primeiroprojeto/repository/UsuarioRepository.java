package com.rd.projetospring.primeiroprojeto.repository;

import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger> {

    List<UsuarioEntity> findByNome(String nome); // SELECT * FROM TB_USUARIO WHERE DS_NOME = ???

    List<UsuarioEntity> findByCpf(String cpf); // SELECT * FROM TB_USUARIO WHERE NR_CPF = ?

    List<UsuarioEntity> findByDtNascimento(Date dtNascimento);

    List<UsuarioEntity> findByNomeAndCpfOrderByDtNascimento(String nome, String cpf);
    //SELECT * FROM TB_USUARIO WHERE NM_NOME = ? AND NR_CPF = ? ORDER BY DT_NASCIMENTO


}

package com.rd.projetospring.primeiroprojeto.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "TB_LOGIN_USUARIO")
@Data
public class LoginUsuarioEntity implements UserDetails {

    @Id
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;

    @Column(name = "DS_SENHA")
    private String dsSenha;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return dsSenha;
    }

    @Override
    public String getUsername() {
        return dsEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

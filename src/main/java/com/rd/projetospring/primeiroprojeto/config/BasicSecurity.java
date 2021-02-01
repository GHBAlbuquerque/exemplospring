package com.rd.projetospring.primeiroprojeto.config;

import com.rd.projetospring.primeiroprojeto.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService service;

    //configuração autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
//        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());

//        auth.inMemoryAuthentication().withUser("admin").password("1234");
    }

    //Configuração das rotas (autorização)
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/usuario").permitAll().and()
                .authorizeRequests().antMatchers(HttpMethod.POST,"/usuario").permitAll().and()
                .authorizeRequests().anyRequest().authenticated().and()
                .httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}

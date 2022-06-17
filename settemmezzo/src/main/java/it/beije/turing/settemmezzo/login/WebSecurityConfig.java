package it.beije.turing.settemmezzo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Disabling Cross-Site-Request-Forgery.
        http.csrf().disable();
       

        //NOTE ::: ROLES =/= AUTHORIZATIONS, Spring security implements 2 similar but different concepts.
        //standard implementation -> role='ADMIN' , authorization='ROLE_ADMIN'
        //The database table contains the authorization, but here we work with roles.
        //Spring security converts them automatically but watch out

        //Here you can apply different authorizations for different users/parts of the web app
        http.authorizeRequests()

        .anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
package it.beije.turing.settemmezzo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import it.beije.turing.settemmezzo.login.security.JwtConfigurer;
import it.beije.turing.settemmezzo.login.security.JwtTokenFilter;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        JwtTokenFilter customFilter = new JwtTokenFilter(new JwtTokenProvider());
        
        //Disabling Cross-Site-Request-Forgery.
        http.csrf().disable();
       

        //NOTE ::: ROLES =/= AUTHORIZATIONS, Spring security implements 2 similar but different concepts.
        //standard implementation -> role='ADMIN' , authorization='ROLE_ADMIN'
        //The database table contains the authorization, but here we work with roles.
        //Spring security converts them automatically but watch out

        //Here you can apply different authorizations for different users/parts of the web app
        http.cors().and()
        .httpBasic().disable()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/test").permitAll()
        .and()
        .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    
}
package it.beije.turing.settemmezzo.login;
import it.beije.turing.settemmezzo.login.security.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import it.beije.turing.settemmezzo.login.security.JwtConfigurer;
import it.beije.turing.settemmezzo.login.security.JwtTokenProvider;
import it.beije.turing.settemmezzo.websocket.service.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;


@SuppressWarnings("deprecation")
@CrossOrigin(origins = "http://localhost:3000")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	

	

	    @Autowired
	 private   UserService userService;
	    
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
			http
					.cors().and()
					.httpBasic().disable()
					.csrf().disable()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.authorizeRequests()
					.antMatchers("/test").permitAll()
					.and()
					.apply(new JwtConfigurer(jwtTokenProvider));
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        super.configure(web);
//			web.ignoring().antMatchers("/**");
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());
	    }


	    private PasswordEncoder getPasswordEncoder() {
	        return new PasswordEncoder() {

	            @Override
	            public boolean matches(CharSequence rawPassword, String encodedPassword) {
	                return encode(rawPassword).equals(encodedPassword);
	            }

	            @Override
	            public String encode(CharSequence rawPassword) {
	                return rawPassword.toString();
	            }
	        };
	    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
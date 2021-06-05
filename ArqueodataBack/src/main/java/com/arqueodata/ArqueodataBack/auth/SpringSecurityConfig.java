package com.arqueodata.ArqueodataBack.auth;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService usuarioService;
	
	/**
	 * Crea contraseña encriptada
	 * 
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Registra en AuthenticationManager el usuarioService para autenticar
	 */
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}
	
	/**
	 * Retorna un authenticationManager para poderlo usar fuera de esta clase
	 * 
	 * @return authenticationManager
	 */
	@Bean("authenticationManager")
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {	
		return super.authenticationManager();
	}
	
	/**
	 * Agrega reglas para los endpoint
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()//cualquier peticion requiere autenticación
		.and()
		.csrf().disable()//deshabilitamos la protección csrf
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//deshabilitamos el manejo de sesiones
	}
	
}

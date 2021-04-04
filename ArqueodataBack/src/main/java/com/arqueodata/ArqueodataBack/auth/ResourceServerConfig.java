package com.arqueodata.ArqueodataBack.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//todo lo que sea permitido para ambos roles va a aquí
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/usuarios","/api/usuarios/{id}",
			"/api/piezas/yacimientos/{id}","/api/piezas/campains/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/piezas","/api/piezas/campains",
			"/api/piezas/yacimientos","/api/uploads/img/**","/images/**").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/usuarios/{id}","/api/piezas/yacimientos/{id}",
			"/api/piezas/campains/{id}","/api/piezas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
		.antMatchers(HttpMethod.POST, "/api/piezas").permitAll()
		.antMatchers(HttpMethod.POST, "/api/piezas/upload").permitAll()
		.antMatchers(HttpMethod.POST, "/api/piezas/yacimientos").permitAll()
		.antMatchers(HttpMethod.POST, "/api/piezas/campains").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api/usuarios/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/piezas/campains/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/piezas/yacimientos/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/piezas/{id}").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config =  new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
		
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	
}

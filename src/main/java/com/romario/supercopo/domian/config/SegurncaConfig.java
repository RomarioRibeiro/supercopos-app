package com.romario.supercopo.domian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SegurncaConfig extends WebSecurityConfigurerAdapter{

	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**",
			"/categorias/**",
			"/produtos/**"
			
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.anyRequest().authenticated();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
}

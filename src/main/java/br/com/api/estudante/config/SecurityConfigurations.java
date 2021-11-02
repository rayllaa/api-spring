package br.com.api.estudante.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	//configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	//configurações de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable();
		
		http
		.authorizeRequests()
		.antMatchers("/estudantes/*").permitAll();
		//.antMatchers(HttpMethod.GET, "/estudantes/*").permitAll();
		
		http
		.headers()
		.frameOptions()
		.disable();
		
	}
	//configurações de recursos estáticos (js, css, imagens, etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
}

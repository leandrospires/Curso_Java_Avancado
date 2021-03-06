package br.com.gestaovendas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/clientes/cadastro").hasRole("ADMIN")
			.antMatchers("/produtos/cadastro").hasAnyRole("ADMIN", "GUEST")
			.antMatchers("/clientes/lista").permitAll()
			.antMatchers("/produtos/lista").permitAll()
			.antMatchers("/users/**").permitAll()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.formLogin().loginPage("/users/login")
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"));
	}

	
}
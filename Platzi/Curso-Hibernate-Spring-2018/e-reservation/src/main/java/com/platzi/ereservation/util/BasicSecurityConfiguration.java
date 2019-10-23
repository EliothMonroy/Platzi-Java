package com.platzi.ereservation.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase para manejar la seguridad con Spring Boot Security Starter
 */
@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/app/login").loginProcessingUrl("/app/login").permitAll()
				.failureUrl("/app/login?error=true").defaultSuccessUrl("/app/home");
	}

	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
		authenticationManagerBuilder.inMemoryAuthentication().withUser("elioth").password(encoder.encode("platzi")).roles("USER");
	}

	public void configure(WebSecurity webSecurity) throws Exception{
		webSecurity.ignoring().antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
	}

}

package com.zensar.tp.securityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailService;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}
	
@Override
protected void configure(HttpSecurity http) throws Exception {
http.csrf().disable();
	http.authorizeRequests()
.antMatchers("/admin").hasRole("ADMIN")
.antMatchers("/user").hasRole("USER")
.antMatchers("/authenticate","/token/validate","/users","/user/logout","/talentportal/job").permitAll()
.and()

.sessionManagement()

.and().formLogin();

}
@Bean
public AuthenticationManager getAuthenticationManager() throws Exception{
	return super.authenticationManager();
}
@Bean
public PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}
}

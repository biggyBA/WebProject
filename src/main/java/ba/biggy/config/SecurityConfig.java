package ba.biggy.config; 

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	 @Autowired
	 DataSource dataSource;
	 
	 
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery(
		   "select username,password, enabled from users where username=?")
		  .authoritiesByUsernameQuery(
		   "select username, role from user_roles where username=?");
	 } 
	
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
       
		//These pages does not require login
        http.authorizeRequests().antMatchers("/login", "/logout", "/test").permitAll();
 
        //For ADMIN only
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        
        //For SERVICEMAN only
        http.authorizeRequests().antMatchers("/serviceman/**").access("hasRole('ROLE_SERVICEMAN')");
        
        //For ADMIN and SERVICEMAN
        http.authorizeRequests().antMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		
		
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .usernameParameter("username")//
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login")
                .permitAll();
        
    }

	
}

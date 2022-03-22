package com.ikbal.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ikbal.springboot.web.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
/*
WebSecurityConfigurerAdapter is a class that is extended by your Spring configuration file,
making it quite easy to bring Spring Security into your Spring application.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//Enable basic authentication
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
        auth.inMemoryAuthentication()
          .withUser("admin")
          .password("{noop}password")
          .roles("USER");
    }
    */
	
	/* 
	The UserDetailsService is a core interface in Spring Security framework, 
	which is used to retrieve the user’s authentication and authorization information.
    This interface has only one method named loadUserByUsername() which we can
    implement to feed the customer information to the Spring security API
    */
   /*
   * Here UserDetails is container for core user information. 
   * According to docs, its implementations are not used directly by Spring Security for security purposes. 
   * They simply store user information which is later encapsulated into Authentication objects. 
   * This allows non-security related user information (such as email addresses, telephone numbers etc) to be 
   * stored in a convenient location. A very good sample implementation can be like User class.
   * Provides core user information.
   */
	
	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	 /* 
	  * Spring Security also has a number of helper classes, which you can set up using AuthenticationManager.
	 	One helper class is the AuthenticationManagerBuilder.
		Using this class, it's quite easy to set up the UserDetailsService against a database*/
	/*AuthenticationProvider provides a mechanism for getting the user details with which authentication can be performed.*/
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	//https://www.section.io/engineering-education/springboot-antmatchers/
    /* http.authorizeRequests() Allows restricting access based upon the HttpServletRequest
     using RequestMatcher implementations (i.e. via URL patterns).*/
    /*The antMatchers() is a Springboot HTTP method used to configure the URL
    paths from which the Springboot application security should permit requests based
    on the user’s roles. The antmatchers() method is an overloaded
    method that receives both the HTTP request methods and the specific URLs as its arguments.*/
    /*hasAnyRole(): This binds the URL to any user whose role is included in the configured roles created in the application.
     It receives a variable-length argument of roles.
     hasRole(): This method receives a single role argument bound to the URL
     hasAuthority(): This method binds the URL to the granted authorities of the client.
     Any client who has been granted certain authorities is authorized to send a request to the URL.
     hasAnyAuthority(): This binds the URL to any user whose granted authorities is included in the configured authorities/permissions created in the application.
     It receives a variable-length argument of granted authorities.
     anonymous(): This binds the URL to an unauthenticated client.
     authenticated(): This binds the URL to any authenticated client.
     formLogin(): form based authentication
     permitAll(): will configure the authorization so that all requests are allowed on that particular path
     formLogin(): Spring Security provides support for username and password being provided through an html form.
     httpBasic():Allows users to authenticate with HTTP Basic authentication
     */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/edit/**", "/delete/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("ikbal123"));		
	}
	   
	
}

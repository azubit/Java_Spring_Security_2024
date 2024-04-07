package com.learn.codewithankur.springsec.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import com.learn.codewithankur.springsec.service.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;
@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class MySecurityConfig {

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpsec) throws Exception {
//		try {
//			httpsec.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated() )
//			.httpBasic(withDefaults());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return httpsec.build();
//	}
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	 @Bean
	    SecurityFilterChain filterChain(HttpSecurity httpsec) throws Exception {

		 HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
		    requestCache.setMatchingRequestParameterName(null);
		    
         httpsec.csrf(AbstractHttpConfigurer::disable).	
				        authorizeHttpRequests((auth) -> {
				     try {
                         auth
                                 .requestMatchers("signin").permitAll()
                                 .requestMatchers("/home/**").hasRole("USER")
                                 .requestMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                                 .anyRequest()
                                 .authenticated()
                                 
                                 .and().userDetailsService(customUserDetailsService)
                                 //.formLogin(login -> login.loginPage("/signin"))
                                 .formLogin(withDefaults()).requestCache((cache) -> cache
                                         .requestCache(requestCache)
                                	        );
                               //  .userDetailsService(customUserDetailsService);
				     } catch (Exception e) {
				         // TODO Auto-generated catch block
				         e.printStackTrace();
				     }
				 });
			
		 return httpsec.build();
		}

	 
   
    @Bean
    static PasswordEncoder passwordEncoder () {
    	return new BCryptPasswordEncoder(10);
    }
    
//    @Bean
//    UserDetailsService detailsService() {
//    	
//    	UserDetails ankur = User.builder().username("ankur").
//    			password(passwordEncoder().encode("ankur123"))
//    			.roles("ADMIN")
//    			.build();
//    	UserDetails swati = User.builder().username("swati").
//    			password(passwordEncoder().encode("swati123"))
//    			.roles("USER")
//    			.build();
//    	
//    	return new InMemoryUserDetailsManager(ankur,swati);    	
//    }

    
    
}

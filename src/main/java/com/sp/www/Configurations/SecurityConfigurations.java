
package com.sp.www.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.sp.www.Services.EmployeeDetails;

@Configuration
public class SecurityConfigurations {
    @Autowired
    EmployeeDetails employeeDetails;
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider =new DaoAuthenticationProvider(employeeDetails);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}

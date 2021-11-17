package com.example.demo.domain.security;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.httpBasic().and().authorizeRequests().antMatchers("/blogpost/search/{id}").hasAnyAuthority("EXECUTE")
                .and().authorizeRequests()
                .antMatchers("/blogpost/delete/{id}").hasAnyAuthority("EXECUTE")
                .and().authorizeRequests()
                .antMatchers("/blogpost/sort/{field}").permitAll()
                .and().authorizeRequests()
                .antMatchers("/blogpost/post/").hasAuthority("WRITE")
                .and().authorizeRequests()
                .antMatchers("/blogpost/search/{id}").hasAuthority("WRITE")
                .and().authorizeRequests()
                .antMatchers("/blogpost/{id}").permitAll()
                .and().formLogin();

    }


}

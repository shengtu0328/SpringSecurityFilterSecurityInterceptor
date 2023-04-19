package com.example.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/", "/home").permitAll()
                .antMatchers("/c").permitAll()
                .antMatchers("/d").hasRole("roled")
                .antMatchers("/e").hasRole("rolee")
                .antMatchers("/f").hasRole("rolef")
                .antMatchers("/i").hasRole("rolei")
//				.antMatchers("/g").hasAuthority("roleg")
                .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .authorities("authorityg")
                //authorities和roles只应该定义一个
                //.roles("admin","rolei")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

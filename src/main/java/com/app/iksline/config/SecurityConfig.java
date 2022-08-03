package com.app.iksline.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.app.iksline.config.Role.ADMIN;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${admin.password}")
  private String adminPassword;
  @Value("${admin.username}")
  private String adminUsername;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole(ADMIN.name())
        .anyRequest().permitAll()
        .and()
        .formLogin();
  }


  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    manager.createUser(User
        .withUsername(adminUsername)
        .password(encoder().encode(adminPassword))
        .roles(ADMIN.name())
        .build());

    return manager;
  }

  @Bean
  public static PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }


}

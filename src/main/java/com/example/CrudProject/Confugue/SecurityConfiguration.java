package com.example.CrudProject.Confugue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/get_user").hasAnyRole("ADMIN","READER")
                .antMatchers(HttpMethod.POST, "/create_user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update_user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/patch_user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete_user/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login") // Specify the custom login page URL
                .successHandler(customAuthenticationSuccessHandler()) // Redirect to the dashboard upon successful login
                .and()
                .httpBasic();
    }
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN")
                .and().withUser("reader1").password("{noop}reader123").roles("READER")
                .and().withUser("reader2").password("{noop}reader456").roles("READER");
    }

}
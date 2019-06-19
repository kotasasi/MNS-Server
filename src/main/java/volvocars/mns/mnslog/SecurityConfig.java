package volvocars.mns.mnslog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
        .withUser("reporter").password("{noop}Dc8IJ2CIzEDYKYyF").roles("USER")
        .and()
        .withUser("apica").password("{noop}uPt0sU0Ma2Irq8KC").roles("USER")
        .and()
        .withUser("jUnit").password("{noop}jUnit").roles("USER")
        .and()
        .withUser("smsGW").password("{noop}adsfs4665T4RGAV").roles("USER");
    }
}

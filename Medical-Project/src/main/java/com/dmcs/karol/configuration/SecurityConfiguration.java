package com.dmcs.karol.configuration;

import com.dmcs.karol.dao.AppUserRoleRepository;
import com.dmcs.karol.domain.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name = "myAppUserDetailsService")
    private UserDetailsService userDetailsService;

    @Resource(name = "appUserRoleRepository")
    private AppUserRoleRepository appUserRoleRepository;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("kapj").password("{noop}kapj").roles("PATIENT");
        auth.inMemoryAuthentication().withUser("student").password("{noop}student").roles("DOCTOR");
        //User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);

        http.authorizeRequests()

                .antMatchers("/updateuser").permitAll()
                .antMatchers("/saveMyVisit").permitAll()
                .antMatchers("/addAppUser").permitAll()
                .antMatchers("/appUserRole*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/admin*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/patient*").hasAuthority("ROLE_PATIENT")
                .antMatchers("/doctor*").hasAuthority("ROLE_DOCTOR")
                .and().formLogin().loginPage("/login").permitAll() // with custom login page
                .and().formLogin().loginPage("/register").permitAll() // with custom login page
                .defaultSuccessUrl("/index1").usernameParameter("email").passwordParameter("password")
                .failureForwardUrl("/login.html?error")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");

    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("*************");
        mailSender.setPassword("*************");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public void createTestData() {
        AppUserRole roleAdmin = new AppUserRole();
        roleAdmin.setRole("ROLE_ADMIN");
        roleAdmin = appUserRoleRepository.save(roleAdmin);

        AppUserRole rolePatient = new AppUserRole();
        rolePatient.setRole("ROLE_PATIENT");
        rolePatient = appUserRoleRepository.save(rolePatient);

        AppUserRole roleDoctor = new AppUserRole();
        roleDoctor.setRole("ROLE_DOCTOR");
        roleDoctor = appUserRoleRepository.save(roleDoctor);
    }

}



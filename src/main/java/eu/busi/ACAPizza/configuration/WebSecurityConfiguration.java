package eu.busi.ACAPizza.configuration;

import eu.busi.ACAPizza.dataAccess.dao.UserDAO;
import eu.busi.ACAPizza.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private static final String LOGIN_REQUEST ="/login";
    private static final String[] AUTHORIZED_REQUEST_ANYBODY = new String []{"/home", "/pizza", "/inscription", "/inscription/send"};
    private static final String[] AUTHORIZED_REQUEST_ADMIN = new String []{"/admin"};
    private static final String[] AUTHORIZED_REQUEST_USER = new String []{"/login"};



//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Qualifier("userDetailsServiceImplementation")
    @Autowired
    public UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder( new BCryptPasswordEncoder());
       auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("paul").password("yo").roles("USER");
       auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("paula").password("yoyo").roles("ADMIN");

    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        String[] staticResources  =  {
                "/css/**",
                "/images/**",
                "/fonts/**",
                "/scripts/**",
        };

        http.csrf().disable(); // désactiver car non necessaire
        http
                .authorizeRequests()
                .antMatchers(AUTHORIZED_REQUEST_ADMIN)  .hasRole("ADMIN")
                .antMatchers(AUTHORIZED_REQUEST_USER)  .hasRole("USER")
                .antMatchers(AUTHORIZED_REQUEST_ANYBODY).permitAll()
                .antMatchers(staticResources).permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
//                .loginPage(LOGIN_REQUEST)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .permitAll();
    }



//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder( passwordEncoder());
//    }


}

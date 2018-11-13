package eu.busi.ACAPizza.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_REQUEST ="/loginPage";
    private static final String[] AUTHORIZED_REQUEST_ANYBODY = new String []{"/panier", "/add", "/pizza/add", "/pizza/add/**", "/home",
                                                                                "/pizza", "/inscription", "/inscription/send",
                                                                                    "/pizzaPerso", "/panier/**/**", "/loginPage"};

    private static final String[] AUTHORIZED_REQUEST_ADMIN = new String []{"/admin"};
    private static final String[] AUTHORIZED_REQUEST_USER = new String []{"/loginPage"};



    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();



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
                "/js/**",
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

                .loginPage(LOGIN_REQUEST)

                .loginProcessingUrl("/loginPage")
//                .successForwardUrl("/home")

//                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        redirectStrategy.sendRedirect(request, response, "/home");
                    }
                })
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

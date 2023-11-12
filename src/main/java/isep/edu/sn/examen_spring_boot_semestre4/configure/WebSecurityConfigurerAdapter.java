package isep.edu.sn.examen_spring_boot_semestre4.configure;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Désactiver CSRF pour simplifier l'exemple
                .authorizeRequests()
                .antMatchers("/api/voters/register", "/api/voters/login").permitAll() // Autoriser l'enregistrement et la connexion
                .antMatchers(HttpMethod.GET, "/api/candidates").permitAll() // Autoriser la récupération des candidats (peut être ajusté)
                .antMatchers("/api/results").hasRole("CANDIDATE") // Seul un candidat peut accéder aux résultats
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/voters/login") // Configurer la page de connexion personnalisée si nécessaire
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    protected abstract void configure
            (AuthenticationManagerBuilder auth) throws Exception;
}

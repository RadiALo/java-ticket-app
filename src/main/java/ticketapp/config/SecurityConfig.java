package ticketapp.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/register").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/cinema-halls",
                        "/movies/**",
                        "/movie-sessions/available/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,
                        "/cinema-halls/**",
                        "/movies/**",
                        "/movie-sessions/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/movie-sessions/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,
                        "/orders",
                        "/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/orders/complete/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/shopping-carts/movie-sessions/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/users/by-email/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
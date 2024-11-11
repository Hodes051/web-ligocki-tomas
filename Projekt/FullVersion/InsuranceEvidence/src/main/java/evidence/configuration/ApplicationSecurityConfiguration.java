package evidence.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                    .requestMatchers("/pojisteni-app/pojistenci/novy","/pojisteni-app/pojistenci/odstranit", "/pojisteni-app/pojistenci/edit")
                        .authenticated()
                    .requestMatchers("/pojisteni-app", "/styles/**", "/images/**", "/pojisteni-app/register")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/pojisteni-app/login")
                    .loginProcessingUrl("/pojisteni-app/login")
                    .defaultSuccessUrl("/pojisteni-app", true)
                    .usernameParameter("email")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/pojisteni-app/logout")
                    .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

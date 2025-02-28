package hotel.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers("/login", "/css/**").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .permitAll())

                                .logout((logout) -> logout.deleteCookies("JSESSIONID")
                                                .invalidateHttpSession(true)
                                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll());
                // .logout((logout) -> logout.logoutSuccessUrl("/login?logout").permitAll());

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withUsername("user")
                                                .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
                                                .roles("USER")
                                                .build();

                // UserDetails user = User.withDefaultPasswordEncoder()
                // .username("user")
                // .password("blackfriday")
                // .roles("USER")
                // .build();

                return new InMemoryUserDetailsManager(user);
        }
}

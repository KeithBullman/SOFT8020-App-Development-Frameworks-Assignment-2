//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/newstudent", "/newnote", "/delete/**", "/student/**", "/inactivestudents").hasRole("ADMIN")
                .antMatchers("/static/**", "/").permitAll()
                .and()
                .formLogin().loginPage("/login")// authenticate by login form
                .and().logout().logoutSuccessUrl("/")
                .and().httpBasic() // and by basic http request
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Create our own instance of Spring's user details but creating some UserDetails objects and
    // creating an in-memory user details manager from these 2 users.
    @Bean
    @Override
    protected UserDetailsService userDetailsService()
    {
        String encodedPassword = passwordEncoder().encode("password");
        UserDetails user1 = User.withUsername("user").password(encodedPassword).roles("USER").build();
        UserDetails user2 = User.withUsername("cliona").password(encodedPassword).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
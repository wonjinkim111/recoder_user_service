package com.yaas.recoderuserservice.security;

import com.yaas.recoderuserservice.security.AuthenticationFilter;
import com.yaas.recoderuserservice.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Arrays;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private Environment env;

    private IUsersService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(Environment env, IUsersService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.env = env;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors() // ✅ CORS 활성화
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/**").permitAll();
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(this.userService, this.env, authenticationManager());
        authenticationFilter.setFilterProcessesUrl("//" + this.env.getProperty("login.url.path"));
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) this.userService)
            .passwordEncoder((PasswordEncoder) this.bCryptPasswordEncoder);
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // 인증정보 포함 허용
        config.setAllowedOrigins(Arrays.asList("http://192.168.1.10:30080"));  // React 앱 주소
        config.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setExposedHeaders(Arrays.asList("Authorization", "userId", "token", "mentorId", "menteeId"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

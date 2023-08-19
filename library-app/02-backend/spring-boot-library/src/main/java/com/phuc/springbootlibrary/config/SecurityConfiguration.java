package com.phuc.springbootlibrary.config;
import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;


@Configuration

public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Disable Cross Site Request Forgery protection
        http.csrf().disable();
//         protect endpoint at /api/<type>/secure
        // Protect endpoints at /api/<type>/secure
        http.authorizeRequests(configurer ->
                        configurer
                                .antMatchers("/api/books/secure/**",
                                        "/api/review/secure/**",
                                        "/api/messages/secure/**",
                                        "/api/admin/secure/**")

                                .authenticated())
                .oauth2ResourceServer()
                .jwt();
        // Add Cors
        http.cors();

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        // Force a non-empty respone body for 401 to make responses friendly
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }


}

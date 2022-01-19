package com.example.mobilephoneopeningservice.security;

import com.example.mobilephoneopeningservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Order(1) //우선순위는 더 많은 request들을 처리하는 Config를 후순위로 둔다.
@Configuration
// 스프링 시큐리티 사용 선언 어노테이션. 사용시 SpringSecurityFilterChain이 자동 포함됨.
@EnableWebSecurity
//@RequiredArgsConstructor
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final LoginService loginService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(loginService);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**") // /api url 로 들어오는 요청에 대해서 아래와 같은 필터를 적용하겠다.
                .csrf().disable() // 정적리소스를 활용하지 않으므로 csrf 필터를 끄겠다.
                .authorizeRequests(request->
                        request.anyRequest().authenticated() // 어떤 요청이든 인증이 되어야만 접근이 가능하다.
                )
                .httpBasic() // basic 토큰 인증을 활용하겠다.
        ;
    }
}
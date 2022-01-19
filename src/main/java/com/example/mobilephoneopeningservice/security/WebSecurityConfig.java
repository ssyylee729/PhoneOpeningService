package com.example.mobilephoneopeningservice.security;

import com.example.mobilephoneopeningservice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Order(2) //우선순위는 더 많은 request들을 처리하는 Config를 후순위로 둔다.
@Configuration
// 스프링 시큐리티 사용 선언 어노테이션. 사용시 SpringSecurityFilterChain이 자동 포함됨.
@EnableWebSecurity
// method 단에서 방어하는 애들 쓰려면 이 어노테이션 필요함.
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    MethodSecurityInterceptor interceptor;
    private final LoginService loginService;
    /**
     * Http 요청에 대하여 보안 상세 설정 적용 메서드
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(request->
                        request
                                .antMatchers("/").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(login ->
                        login
                                .loginPage("/login") // 로그인 페이지 설정
                                .permitAll() // 로그인 페이지에 대해서는 누구나 접근 가능하도록 허용
                                .defaultSuccessUrl("/main", false) // 성공 시 redirect 할 URL 설정
                                .failureUrl("/login") // 로그인 실패시 redirect할 페이지 설정
//                                .usernameParameter("email") // username 파라미터 커스텀.
                )
                .logout(logout ->
                             logout.logoutSuccessUrl("/login") // 로그아웃 성공시 redirect 할 페이지 설정
                );
    }
    /**
     * 스프링 시큐리티 필터 체인에 대한 커스텀 설정 적용 메서드. 필터 적용 무시 등에 대해 설정 가능.
     **/
    @Override
    public void configure(WebSecurity web) throws Exception {
        //static resources에 대해선 접근 허용
        web.ignoring().antMatchers("/bootstrap/**", "/css/**","/js/**", "/img/**", "/bootstrap/vendor/**", "/bootstrap/scss/**");
    //common resources 는 static 아래에.
    }

    /**
     * userDetailsService 지정
     * 테스트용 인메모리 계정 생성
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService);
//        auth.inMemoryAuthentication()
//                .withUser(User
//                        .builder()
//                        .username("user1@mail.com")
//                        .password(passwordEncoder().encode("1111"))
//                        .roles("USER"))
//                .withUser(User.builder()
//                        .username("admin@mail.com")
//                        .password(passwordEncoder().encode("3333"))
//                        .roles("ADMIN"));
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

        return roleHierarchy;
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
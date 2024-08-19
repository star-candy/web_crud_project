package com.curd.test.project.config.auth;


import lombok.RequiredArgsConstructor;
import com.curd.test.project.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//h2(db관리 프로그램) 접속 위한 보안 코드 비활성화
                .headers().frameOptions().disable()//보안 코드 비활성화
                .and()
                .authorizeRequests() //url에 따른 권한 관리 시작점 - 이후 antMatcher 사용 가능
                // 지정 URL은 전체 열람 권한 부여 -permitAll
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                //특정 URL은 일반 사용자(USER) role 부여 대상만 접근 가능
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                //나머지 url에 대해 인정 사용자(로그인)만 접근 가능
                .anyRequest().authenticated() 
                .and()
                //로그아웃 설정 진입점
                .logout()
                .logoutSuccessUrl("/") //로그아웃시 초기화면으로 
                .and()
                //로그인 설정 진입점
                .oauth2Login()
                .userInfoEndpoint() //로그인 성공 후 사용자 정보 가져오는 설정 담당
                .userService(customOAuth2UserService); //로그인 후 후속조치 인터페이스 등록
    }
}
package com.curd.test.project.config;

import com.curd.test.project.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//LoginUserArgumentResolver spring에서 인식되기 위한 class
@RequiredArgsConstructor //생성자 자동 주입
@Configuration //bean 메서드가 사용됨 명시하는 class 어노테이션 (bean 수동 등록 위함)
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    //handler는 addArg 메서드를 통해 추가할 것
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
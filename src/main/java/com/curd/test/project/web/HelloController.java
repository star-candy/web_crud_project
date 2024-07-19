package com.curd.test.project.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json을 반환하는 컨트롤러 제작
public class HelloController {
    @GetMapping("/hello") //http의 get 요청 받는 api 생성
    public String hello() {
        return "hello";
    }
}

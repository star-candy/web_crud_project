package com.curd.test.project.web;
import com.curd.test.project.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json을 반환하는 컨트롤러 제작
public class HelloController {
    @GetMapping("/hello") //http의 get 요청 받는 api 생성
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,//외부에서 넘긴 "name"이름의 파라미터를 name에 저장함
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount); //반환된 파라미터를 생성자 인자로 하는 class 반환
    }
}

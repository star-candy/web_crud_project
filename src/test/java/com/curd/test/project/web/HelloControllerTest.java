package com.curd.test.project.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //springboot를 통해 테스트 진행
@WebMvcTest(controllers = HelloController.class) //web 테스트를 위함, mvc 객체 bean 등록
public class HelloControllerTest {

    @Autowired //spring에 bean 입력, 특정 객체가 bean 등록 x 시 의존성 주입 실패
    private MockMvc mvc;//mvc테스트 시작점, autowired 통해 스프링이 자동으로 mvc 객체 주입

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //mvc 통해 /hello get 요청
                .andExpect(status().isOk()) //요청에 대한 상태 검증, 200상태인가
                .andExpect(content().string(hello));//return값이 hello인가
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                                .param("name", name) //test에서 사용되는 요청 파라미터, string 값만 저장 가능
                                .param("amount", String.valueOf(amount))) //int to string -> "1000"
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //응답 값 검증 메서드, $후위 필드 값을 검증함
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
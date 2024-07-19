package com.curd.test.project.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //springboot를 통해 테스트 진행
@WebMvcTest(controllers = HelloController.class) //web 테스트를 위함, controller에 대한 테스트만 가능
public class HelloControllerTest {

    @Autowired //spring의 bean 입력
    private MockMvc mvc;//mvc테스트 시작점, api 테스트 진행

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //mvc 통해 /hello get 요청
                .andExpect(status().isOk()) //요청에 대한 상태 검증, 200상태인가
                .andExpect(content().string(hello));//return값이 hello인가
    }

}
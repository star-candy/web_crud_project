package com.curd.test.project.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; //assertj 기능 사용

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //검증 대상을 인자로, isEqualTo 통해 테스트 결과 확인 가능
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
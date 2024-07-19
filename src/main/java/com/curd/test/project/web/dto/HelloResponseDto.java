package com.curd.test.project.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//모든 변수에 get 메서드 생성
@RequiredArgsConstructor //final 변수에 대한 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

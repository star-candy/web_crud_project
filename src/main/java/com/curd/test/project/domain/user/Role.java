package com.curd.test.project.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//사용자간 권한 관리 위한 enum class
@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),  //spring 권한 key에는 ROLE_ 명칭 필요
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}

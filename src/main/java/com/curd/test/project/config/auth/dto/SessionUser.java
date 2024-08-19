package com.curd.test.project.config.auth.dto;

import com.curd.test.project.domain.user.User;
import lombok.Getter;
import java.io.Serializable;

//사용자 정보 저장위한 dto
//자바 직렬화 기능 구현 통해 세션 저장 가능(Serializable)
//유저 정보 class(User)는 db와 매핑 class(엔티티)로 타 기능과 연동 가능성 존재,
//User class의 직렬화 시 부수효과 문제 가능성 존재, 따라서 세션 저장 class 추가 구현
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

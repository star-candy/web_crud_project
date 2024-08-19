package com.curd.test.project.config.auth.dto;

import com.curd.test.project.domain.user.Role;
import com.curd.test.project.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }
    //of 메서드로 여러 매개변수 받아 적합한 객체 반환하는 기능, 단일 매개변수시 from 메서드 사용관례
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {

        /*if("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }*/

        return ofGoogle(userNameAttributeName, attributes);
    }

    //빌더 통한 객체 생성 메서드
    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    /*private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }*/

    //최초 가입시 user 엔티티 생성, 초기 role은 guest 지정
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
package com.curd.test.project.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //메서드 파라미터로 사용된 객체에 사용됨
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {//어노테이션 클래스 지정 : @LoginUser 사용 가능
}
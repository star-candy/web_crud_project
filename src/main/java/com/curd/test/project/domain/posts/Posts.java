package com.curd.test.project.domain.posts;

import com.curd.test.project.domain.BaseTimeEntity;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //모든 필드 대한 getter 정의
@NoArgsConstructor //기본 생성자 정의
@Entity //jpa annotation, 테이블과 매핑되는 클래스 의미
public class Posts extends BaseTimeEntity {//entity의 저장, 수정 등 공통 인자에 대해 자동 저장하는 baseTime 상속

    @Id //class의 필드 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 규칙 정의
    private Long id;

    @Column(length = 500, nullable = false) //테이블 열 의미(size 500)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //class의 빌더, 값 초기화요소 명시하는 생성자
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
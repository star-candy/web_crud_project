package com.curd.test.project.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //baseTime을 상속받은 class의 필드를 column으로 인식함
@EntityListeners(AuditingEntityListener.class) //모든 도메인이 가지는 공통 필드(생성, 수정일 등)를 자동으로 db 테이블에 매핑함
public abstract class BaseTimeEntity {

    @CreatedDate //entity 저장시 해당 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate//entity 수정시 해당 시간 자동 저장
    private LocalDateTime modifiedDate;

}
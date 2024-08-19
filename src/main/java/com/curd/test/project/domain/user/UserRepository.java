package com.curd.test.project.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
//user class로 db 접근 위한 jpaRepo 상속
//user 정보 crud 담당
public interface UserRepository extends JpaRepository<User, Long> { 
    Optional<User> findByEmail(String email);
    //반환된 email 값이 db에 존재하는지 확인, 미리 가입 여부 판단 메서드
    //Optional 타입 통해 null값 입력으로 인한 에러 방지
}

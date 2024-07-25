package com.curd.test.project.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;
//jpaRepository<class, pk type> 상속 시 기본 crud 메서드 생성,
//entity class, repo는 한 위치에 존재해야 함m
public interface PostsRepository extends JpaRepository<Posts, Long> { //posts class로 db 접근 가능하게 하기 위한 jparepository
    /*@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();*/
}
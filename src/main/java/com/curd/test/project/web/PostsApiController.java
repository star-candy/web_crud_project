package com.curd.test.project.web;


import com.curd.test.project.service.PostsService;
import com.curd.test.project.web.dto.PostsListResponseDto;
import com.curd.test.project.web.dto.PostsResponseDto;
import com.curd.test.project.web.dto.PostsSaveRequestDto;
import com.curd.test.project.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor //autowired 대신 final로 선언된 모든 필드의 생성자 자동 생성
@RestController //json 형식의 데이터를 받거나 반환시 사용
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") //save(post) btn 클릭 시 해당 url로 data 객체 전송함 (index.js)
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
    //index js save시 반환되는 json 객체는 @Requestbody 통해 java 객체로 변환 및 매핑됨

    @PutMapping("/api/v1/posts/{id}") //update, delete 경우 기본 posts url + id 주소로 객체 전송
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    } //index js의 dataType이 json = 요청에 대한 반환값을 기대하고 있음
    // 따라서 db의 id 값을 반환하여 요청이 정상 처리되었음을 알려야 함

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}

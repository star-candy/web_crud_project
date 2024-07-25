package com.curd.test.project.service;


import com.curd.test.project.domain.posts.Posts;
import com.curd.test.project.domain.posts.PostsRepository;
import com.curd.test.project.web.dto.PostsResponseDto;
import com.curd.test.project.web.dto.PostsSaveRequestDto;
import com.curd.test.project.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //더티 체킹 가능

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) { //id 받아와서 postRepository에 저장
        return postsRepository.save(requestDto.toEntity()).getId(); //save 동작은 insert 쿼리를 발생시킬 것
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {//기존 id가 jpa내에 존재한다면 게시글의 제목, 내용 update
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent()); //update 기능을 수행함,
        //update는 기존 값이 save 동작을 통해 jpa 쿼리에 등록된 상태이고 해당 값을 바꿀 때에는 쿼리 날리지 않아도 변경 자동 반영됨 (더티 체킹)
        //따라서 postsRepository로 쿼리 날리지 않음
        return id;
    }


    /*
    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
    */
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
    /*
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }*/
}
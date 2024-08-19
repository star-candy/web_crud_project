package com.curd.test.project.web;

import com.curd.test.project.config.auth.dto.SessionUser;
import com.curd.test.project.service.PostsService;
import com.curd.test.project.web.dto.PostsResponseDto;
import javax.mail.Session;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save") //posts/save 호출 시 posts-save 문자열 호출
    public String postsSave() {
        return "posts-save"; //해당 문자열 자동으로 경로 + mustache 태그 붙여짐
    }

    @GetMapping("/posts/update/{id}") //게시글 수정 요청시 호출
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update"; ///posts-update.mustache
    }
}
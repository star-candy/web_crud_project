package com.curd.test.project.web;



//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RequiredArgsConstructor
@Controller
public class IndexController {

    //private final PostsService postsService;

    @GetMapping("/") //mustach starter 의존성 사용으로 문자열의 경로, 확장자는 자동으로 지정
    public String index() {
        return "index"; //src/main....index.mustache로 인식됨
    }
//    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser user) {
//        model.addAttribute("posts", postsService.findAllDesc());
//        if (user != null) {
//            model.addAttribute("userName", user.getName());
//        }
//        return "index";
//    }

//    @GetMapping("/posts/save")
//    public String postsSave() {
//        return "posts-save";
//    }
//
//    @GetMapping("/posts/update/{id}")
//    public String postsUpdate(@PathVariable Long id, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post", dto);
//
//        return "posts-update";
//    }
}
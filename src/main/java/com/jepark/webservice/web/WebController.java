package com.jepark.webservice.web;

import com.jepark.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jepark3452@gmail.com on 16/10/2018
 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}

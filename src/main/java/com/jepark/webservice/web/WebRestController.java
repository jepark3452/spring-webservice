package com.jepark.webservice.web;

import com.jepark.webservice.domain.posts.PostsRepository;
import com.jepark.webservice.domain.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jepark3452@gmail.com on 12/10/2018
 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    /*@GetMapping("/hello")
    public String hello() {
        return "HelloWorld!";
    }*/

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}

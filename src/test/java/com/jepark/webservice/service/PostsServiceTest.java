package com.jepark.webservice.service;

import com.jepark.webservice.domain.posts.Posts;
import com.jepark.webservice.domain.posts.PostsRepository;
import com.jepark.webservice.domain.posts.PostsSaveRequestDto;
import com.jepark.webservice.dto.PostsMainResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jepark3452@gmail.com on 16/10/2018 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jepark3452@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

    @Test
    public void 최초데이터가_역순으로_조회된다() {
        // given
        Posts entity = Posts.builder()
                .author("test2@gmail.com")
                .title("테스트2")
                .build();

        PostsMainResponseDto dto = PostsMainResponseDto.builder()
                .entity(entity)
                .build();

        // when
        List<PostsMainResponseDto> list = postsService.findAllDesc();

        // then
        PostsMainResponseDto descDto = list.get(0);
        assertThat(descDto.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(descDto.getTitle()).isEqualTo(dto.getTitle());
    }

}

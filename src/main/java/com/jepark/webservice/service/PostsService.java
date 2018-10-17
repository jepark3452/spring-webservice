package com.jepark.webservice.service;

import com.jepark.webservice.domain.posts.PostsRepository;
import com.jepark.webservice.domain.posts.PostsSaveRequestDto;
import com.jepark.webservice.dto.PostsMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jepark3452@gmail.com on 16/10/2018
 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
            .map(PostsMainResponseDto::new)
            .collect(Collectors.toList());
    }
}

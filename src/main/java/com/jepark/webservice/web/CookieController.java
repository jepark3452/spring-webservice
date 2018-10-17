package com.jepark.webservice.web;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jepark3452@gmail.com on 16/10/2018
 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */

@RestController
public class CookieController {

    @GetMapping("/cookie")
    public String getCookie(@CookieValue("user") String user) {
        return user + "님 안녕하세요!";
    }
}

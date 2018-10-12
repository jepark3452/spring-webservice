package com.jepark.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by jepark3452@gmail.com on 12/10/2018
 * Blog: http://jepark3452.tistory.com
 * Github: https://github.com/jepark3452
 */
@SpringBootApplication
public class Application {

    //h2 확인시 jdbc url ==> jdbc:h2:mem:testdb
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

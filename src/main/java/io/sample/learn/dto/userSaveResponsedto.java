package io.sample.learn.dto;

import io.sample.learn.entity.User;
import lombok.*;

@Getter

public class userSaveResponsedto {
    private Long id;
    private int age;
    private String name;

//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;


     public userSaveResponsedto(Long id, int age, String name ) {
        this.id = id;
        this.age = age;
        this.name = name;


    }


}
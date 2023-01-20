package io.sample.learn.dto;

import io.sample.learn.entity.User;
import lombok.*;

@Getter

public class userSaveResponsedto {
    private Long id;
    private int age;
    private String name;

    private String email;

    private String password;

//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;


    public userSaveResponsedto(Long id, int age, String name, String email, String password) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public static userSaveResponsedto from(User user) {
        if (user == null) return null;

        return new userSaveResponsedto(user.getId(), user.getAge(), user.getName(),
                user.getEmail(),user.getPassword());
    }

}
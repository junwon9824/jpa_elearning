package io.sample.learn.dto;

import io.sample.learn.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class userUpdateRequestdto {

    private int age;
    private String name;

    private String  email;
    private String  password;

    public User toEntity() {
        User build = User.builder()
                .age(age)
                .name(name)
                .email(email)
                .password(password)
                .build();
        return build;

    }


    @Builder
    public userUpdateRequestdto(int age, String name,String email ,String password ) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password= password;


    }


}
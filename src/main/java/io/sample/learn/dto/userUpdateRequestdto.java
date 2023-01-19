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

    public User toEntity() {
        User build = User.builder()
                .age(age)
                .name(name)
                .build();
        return build;

    }


    @Builder
    public userUpdateRequestdto(int age, String name) {
        this.age = age;
        this.name = name;


    }


}
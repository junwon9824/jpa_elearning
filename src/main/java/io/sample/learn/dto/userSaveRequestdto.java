package io.sample.learn.dto;

import io.sample.learn.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class userSaveRequestdto {
    private Long id;
    private int age;
    private String name;

//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;

    public User toEntity() {
        User build = User.builder()
                .age(age)
                .name(name)
                .build();
        return build;

    }


    @Builder
    public userSaveRequestdto(Long id, int age, String name ) {
        this.id = id;
        this.age = age;
        this.name = name;


    }


}
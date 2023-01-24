package io.sample.learn.dto;


 import lombok.*;

@Getter @Setter
public class SignRequest {

    private Long id;

    private String account;

    private String password;

    private String nickname;

    private String name;

    private String email;

}

package io.sample.learn.dto;

import io.sample.learn.entity.Member;
import lombok.*;

@Getter
@Setter
@Builder
public class alluserresponse {

    private String account;

    private String name;
    private String nickname;

    public static alluserresponse from(Member member)
    {
        return alluserresponse.builder()
                .account(member.getAccount())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();

    }

}

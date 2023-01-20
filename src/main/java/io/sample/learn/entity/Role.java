package io.sample.learn.entity;

import lombok.*;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER"),
    TEACHER("ROLE_TEACHER"),
    ADMIN("ROLE_ADMIN");

    private final String value;
}
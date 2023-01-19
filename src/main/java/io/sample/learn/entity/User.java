package io.sample.learn.entity;

import io.sample.learn.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//
//    @CreatedDate
//    @Column(updatable = true)
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Builder
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age) {
        this.name = name;
        this.age = age;

    }
}
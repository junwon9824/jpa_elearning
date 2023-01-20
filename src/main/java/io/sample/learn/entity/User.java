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
//@Table(name="user")

public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private String password;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public User(String name, int age,String email,String password,Role role) {
        this.name = name;
        this.age = age;
        this.email= email;
        this.password= password;
        this.role= role;
    }

    public void update(String name, int age,String email,String password,Role role) {
        this.name = name;
        this.age = age;
        this.email= email;
        this.password= password;
        this.role= role;
    }

    public boolean isequalpassword(String password)
    {
        return this.password.equals(password);
    }

}
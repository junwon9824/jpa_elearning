package io.sample.learn.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor @Builder

public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JoinColumn(name = "members")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Member members;

    public void setMember(Member member) {
        this.members = member;
    }

}
package io.sample.learn.entity;

import io.sample.learn.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String account;

    private String password;

    private String nickname;

    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "members", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Roles> roles = new ArrayList<>();



    @OneToMany(mappedBy = "member")
    private List<BuyFiles> files = new ArrayList<>();


    public void setRoles(List<Roles> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }


    public void setFile(List<BuyFiles> files) {
        this.files= files;
     }


    public void setPassword(String pwd)
    {
        this.password=pwd;
    }

}
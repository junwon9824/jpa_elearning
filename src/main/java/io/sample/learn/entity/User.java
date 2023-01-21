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
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})

public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String name;
    private String password;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String email; //아이디로 사용할예정
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;
//
//

    @Builder
//    public User(String name, int age,String email,String password,Role role) {
    public User(String name, String username, String email, String password, int age) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;

    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;


    //    public void update(String name, int age,String email,String password,Role role) {
    public void update(String name, int age, String email, String password) {
        this.username = name;
        this.age = age;
        this.email = email;
        this.password = password;
//        this.role= role;
    }


//
//    //에러유발
//    //계정이 갖고있는 권한 목록은 리턴
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        Collection <GrantedAuthority> collectors = new ArrayList<>();
//        collectors.add(() -> {
//            return "계정별 등록할 권한";
//        });
//
//        //collectors.add(new SimpleGrantedAuthority("Role"));
//
//        return collectors;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    //계정이 만료되지 않았는지 리턴 (true: 만료 안됨)
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    //계정이 잠겨있는지 않았는지 리턴. (true: 잠기지 않음)
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    //비밀번호가 만료되지 않았는지 리턴한다. (true: 만료 안됨)
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    //계정이 활성화(사용가능)인지 리턴 (true: 활성화)
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

}
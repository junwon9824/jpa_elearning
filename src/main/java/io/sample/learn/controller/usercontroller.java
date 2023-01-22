package io.sample.learn.controller;


 import io.sample.learn.dto.SignUpDto;
 import io.sample.learn.dto.userSaveResponsedto;
import io.sample.learn.dto.userUpdateRequestdto;
// import io.sample.learn.entity.Role;
 import io.sample.learn.entity.User;
 import io.sample.learn.jwt.JwtTokenProvider;
 import io.sample.learn.repository.UserRepository;
 import io.sample.learn.service.UserService;

import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.web.bind.annotation.*;

 import java.util.Collections;
 import java.util.*;
import org.springframework.ui.Model;

@RequiredArgsConstructor


@RestController
public class usercontroller {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))

                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build()).getId();
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


    @GetMapping("/users")
    public List<userSaveResponsedto> findall() {
        return userService.findusers();

    }



    @PostMapping("/user")
    public String save(userSaveResponsedto dto) {
        Long id = userService.save(dto);
        return "your number is " + id;

    }



    @PutMapping("/user/{id}")
    public String update(@PathVariable Long id, userUpdateRequestdto dto) {
        return "modified id:" + userService.update(id, dto);

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("delete success id:" + id);
    }





}


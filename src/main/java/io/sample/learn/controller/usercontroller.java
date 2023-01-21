package io.sample.learn.controller;


 import io.sample.learn.dto.SignUpDto;
 import io.sample.learn.dto.userSaveResponsedto;
import io.sample.learn.dto.userUpdateRequestdto;
 import io.sample.learn.entity.Role;
 import io.sample.learn.entity.User;
import io.sample.learn.service.UserService;

import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 import java.util.Collections;
 import java.util.List;
import org.springframework.ui.Model;

@RequiredArgsConstructor


@RestController
public class usercontroller {
    private final UserService userService;

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




//
//    @PostMapping("/api/add_admin")
//     public ResponseEntity<?> registerUser(int age) {
//
//        SignUpDto signUpDto = null;
//        signUpDto.setAge(age);
//        signUpDto.setName("d");
//        signUpDto.setEmail("dd");
//        signUpDto.setPassword("e");
//        signUpDto.setUsername("e");
//
//        Role roles =new Role("ADMIN");
//
//
//        userService.registeradmin(signUpDto);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
//    }


}


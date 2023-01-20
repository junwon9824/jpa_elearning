package io.sample.learn.controller;


import io.sample.learn.dto.userSaveResponsedto;
import io.sample.learn.dto.userUpdateRequestdto;
import io.sample.learn.entity.User;
import io.sample.learn.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


//
//    @PostMapping("/user")
//    public Long save(@RequestParam String name, @RequestParam int age) {
//        return userService.save(name, age);
//    }
////
//    @PostMapping("/users")
//    public Long saves(User user) {
//        return userService.save2(user);
//    }
//
//    @PostMapping("/user")
//    public Long save(userSaveResponsedto dto) {
//
//        return userService.save(dto);
//
//    }

    @PostMapping("/user")
    public String save(  userSaveResponsedto dto) {
        Long id=userService.save(dto);
        return "your nmuber is "+id;

    }

    @PutMapping("/user/{id}")
    public String update(@PathVariable Long id, userUpdateRequestdto dto) {
        return "modified id:"+ userService.update(id, dto);

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("delete success id:"+id);
    }
//
//    @PostMapping("/login")
//    public

}


//package io.sample.learn.controller;
//
//import io.sample.learn.dto.userSaveRequestdto;
//import io.sample.learn.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class usercontrollerTest {
//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//
//    }
//
//    @Test
//    public void save() {
//        String name = "won";
//        int age = 1;
//        userSaveRequestdto dto = userSaveRequestdto.builder()
//                .name(name)
//                .age(age)
//                .build();
//
//
//    }
//
//
//}
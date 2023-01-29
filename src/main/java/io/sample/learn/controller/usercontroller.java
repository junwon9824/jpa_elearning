package io.sample.learn.controller;

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

    @GetMapping(value = "/user/boughtfiles")
    public ResponseEntity<String> showboughtfiles(@RequestParam String email)
    {
        return new ResponseEntity<>( userService.showboughtfiles(email),HttpStatus.OK);
    }


}


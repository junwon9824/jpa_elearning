package io.sample.learn.controller;

import io.sample.learn.dto.LoginDto;
import io.sample.learn.dto.SignUpDto;
import io.sample.learn.entity.Role;
import io.sample.learn.entity.User;
import io.sample.learn.repository.RoleRepository;
import io.sample.learn.repository.UserRepository;
import io.sample.learn.service.RoleService;
import io.sample.learn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
 public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        String username = loginDto.getUsernameOrEmail();
        String pwd = loginDto.getPassword();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

    }

    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
    public ResponseEntity<?> registerUser(SignUpDto signUpDto) {

        // add check for username exists in a DB
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        String name = signUpDto.getName();

        String username = signUpDto.getUsername();
        String email = signUpDto.getEmail();
        String pwd = signUpDto.getPassword();
        int age = signUpDto.getAge();
        // create user object
        User user = new User(name, username, email, pwd, age);

//        Role role=new Role("USER");
        Role role=roleService.findByName("USER");

        user.setRoles(Collections.singleton(role));


        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }

    //add admin
    @PostMapping("/roleadd")
    public  ResponseEntity<String> addrole(Role role)
    {
        roleRepository.save(role);
        return new ResponseEntity<>("role added  successfully!.", HttpStatus.OK);

    }



}
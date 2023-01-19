package io.sample.learn.service;

//import io.sample.learn.dto.userdto;

import io.sample.learn.dto.userdto;
import io.sample.learn.entity.User;
import io.sample.learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.*;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
//
//    @Transactional
//    public Long save(String name, int age) {
//        return userRepository.save(User.builder()
//                .name(name)
//                .age(age)
//                .build()).getId();
//    }

//
//    @Transactional
//    public Long save2(User user) {
//        return userRepository.save(User.builder()
//                .name(user.getName())
//                .age(user.getAge())
//                .build()).getId();
//    }


    @Transactional
    public Long save(userdto dto) {
        return userRepository.save(User.builder()
                .name(dto.getName())
                .age(dto.getAge())

                .build()).getId();

    }



}

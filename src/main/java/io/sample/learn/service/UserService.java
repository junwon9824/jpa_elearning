package io.sample.learn.service;

//import io.sample.learn.dto.userdto;

import io.sample.learn.dto.userSaveRequestdto;
import io.sample.learn.dto.userSaveResponsedto;
import io.sample.learn.dto.userUpdateRequestdto;
import io.sample.learn.entity.User;
import io.sample.learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


    @Transactional
    public Long save(userSaveResponsedto dto) {
        return userRepository.save(User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build()).getId();

    }



    @Transactional
    public long update(Long id, userUpdateRequestdto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사람이 없습니다"));

        user.update(dto.getName(), dto.getAge(), dto.getEmail(), dto.getPassword());

        return id;
    }


    public List<userSaveResponsedto> findusers() {
        return userRepository.findAll().stream()
                .map(user -> userSaveResponsedto.from(user))
                .collect(Collectors.toList());


    }

    @Transactional
    public Long delete(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user doesn't exist"));

        userRepository.delete(user);
        return user.getId();
    }

}

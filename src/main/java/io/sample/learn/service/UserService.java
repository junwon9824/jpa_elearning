package io.sample.learn.service;

//import io.sample.learn.dto.userdto;

import io.sample.learn.dto.userSaveRequestdto;
import io.sample.learn.dto.userSaveResponsedto;
import io.sample.learn.dto.userUpdateRequestdto;
import io.sample.learn.entity.User;
import io.sample.learn.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    public Long save(userSaveResponsedto dto) {
        return userRepository.save(User.builder()
                .name(dto.getName())
                .age(dto.getAge())

                .build()).getId();

    }

    @Transactional
    public long update(Long id, userUpdateRequestdto dto){
        User user=userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당사람이 없습니다"));
        user.update( dto.getName(),dto.getAge());

        return id;
    }
//
//    @Transactional
//    public List<userSaveResponsedto> findall(){
//
//        return userRepository.findAll().stream()
//                .map(User -> modelMapper.map  )
//                .collect(Collectors.toList());
//
//
//    }

}

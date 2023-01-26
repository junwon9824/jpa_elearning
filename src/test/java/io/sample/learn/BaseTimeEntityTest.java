//package io.sample.learn;
//
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class BaseTimeEntityTest {
//    @Autowired
//    private   UserRepository userRepository;
//
//    @Test
//    public void insertbasetime(){
//        LocalDateTime now=LocalDateTime.now();
//         userRepository.save(User.builder().age(11).name("ho").build());
//
//        List<User> list=userRepository.findAll();
//        User user=list.get(0);
//
//        System.out.println("createdate "+user.getCreatedDate()+"modified"+user.getModifiedDate());
////        assertThat(user.getCreatedDate()).isAfter(now);
//    }
//
//}
//package io.sample.learn.repository;
//
//import io.sample.learn.entity.Users;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@Slf4j
//
//class UserrepositoryTest {
//
//    @Autowired
//    Userrepository userrepository;
//
//
//    @BeforeEach
//    void setUp() {
//        Users users=new Users();
//        users.setUsername("kim c");
//        userrepository.save(users);
//
//          users=new Users();
//        users.setUsername("kim l");
//        userrepository.save(users);
//
//          users=new Users();
//        users.setUsername("park j" );
//        userrepository.save(users);
//
//    }
//
//
//
//    @Test
//    void findall() {
//        List<Users> list=userrepository.findAll();
//        for(Users u:list) log.info(u.getId()+"  "+u.getUsername());
//
//    }
//
//    @Test
//    void findbyname(){
//        List<Users> list=userrepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
//        for(Users u:list) log.info(u.getId()+" "+u.getUsername());
//    }
//}
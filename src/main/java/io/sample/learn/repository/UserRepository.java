package io.sample.learn.repository;

import io.sample.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
    //error 조장
}
package io.sample.learn.repository;

import io.sample.learn.dto.alluserresponse;
import io.sample.learn.entity.*;

import jakarta.transaction.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByAccount(String account);
     List<Member> findAll();

     Member findByemail(String email);
    Optional<String > deleteByAccount(String account);

}
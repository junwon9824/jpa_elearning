//package io.sample.learn.repository;
//
//import io.sample.learn.entity.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserREpositoryimp implements UserRepository{
//    public Optional<User> findByEmail(String email){
//        return em.createQuery("select m from Member m where m.email = :email",Member.class)
//                .setParameter("email", email)
//                .getResultList().stream().findAny();
//    }
//
//}

//package io.sample.learn.entity;
//
//import lombok.*;
//
//import jakarta.persistence.*;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "roles",
//        uniqueConstraints= {
//        @UniqueConstraint(columnNames = {"name"})
// })
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(length = 60)
//    private String name;
//
//
////    @Builder
////    public User(String name, int age,String email,String password,Role role) {
////    public Role(String name) {
////
////        this.name = name;
////
////    }
//
//}
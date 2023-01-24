//package io.sample.learn.controller;
//
//import io.sample.learn.dto.*;
//import io.sample.learn.repository.*;
//import io.sample.learn.service.*;
//import jakarta.validation.Valid;
//import lombok.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RequestMapping("/member")
//@RestController
//public class MemberController {
//
//    private final MemberService memberService;
//    private final MemberRepository memberRepository;
//
//    @PostMapping("/join")
//    @ResponseStatus(HttpStatus.OK)
//    public Long join(@Valid @RequestBody MemberSignUpRequestDto request) throws Exception {
//        return memberService.signUp(request);
//    }
//}
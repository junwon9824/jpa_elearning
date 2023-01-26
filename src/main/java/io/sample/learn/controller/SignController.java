package io.sample.learn.controller;

import io.sample.learn.dto.*;
import io.sample.learn.entity.Member;
import io.sample.learn.repository.*;
import io.sample.learn.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService memberService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.register(request), HttpStatus.OK);
    }

    @GetMapping(value = "/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(memberService.getMember(account), HttpStatus.OK);
    }

    @GetMapping(value = "/user/getusers")
    public ResponseEntity<List<alluserresponse>> getmembers() throws Exception {
        return new ResponseEntity<>(memberService.getmembers(), HttpStatus.OK);
    }
//
//     return userRepository.findAll().stream()
//    //                .map(user -> userSaveResponsedto.from(user))
////                .collect(Collectors.toList());
////

    @GetMapping(value = "/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String account) throws Exception {
        return new ResponseEntity<>(memberService.getMember(account), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/delete/{account}")
    public ResponseEntity<String> remove(@PathVariable String account) throws Exception {

        return new ResponseEntity<>(memberService.deleteaccount(account), HttpStatus.OK);
    }

    @PutMapping(value = "/user/modify/{account}")
    public ResponseEntity<String> modify(@PathVariable String account, @RequestParam String password) throws Exception {
        return new ResponseEntity<>(memberService.modifypwd(account, password), HttpStatus.OK);


    }
}
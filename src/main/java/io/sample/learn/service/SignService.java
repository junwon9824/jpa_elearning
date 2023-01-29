package io.sample.learn.service;

import io.sample.learn.config.*;
import io.sample.learn.dto.*;
import io.sample.learn.entity.*;
import io.sample.learn.jwt.JwtProvider;
import io.sample.learn.repository.*;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignRequest request) throws Exception {
        Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .id(member.getId())
                .account(member.getAccount())
                .name(member.getName())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .roles(member.getRoles())
                .token(jwtProvider.createToken(member.getAccount(), member.getRoles()))
                .build();

    }
    @Transactional
//    public String register(SignRequest request) throws Exception {
    public String register(SignRequest request)  {
//        try {
            if(memberRepository.findByAccount(request.getAccount()).isPresent()) {
                throw new IllegalArgumentException("account exists.");

            }

            Member member = Member.builder()
                    .account(request.getAccount())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .nickname(request.getNickname())
                    .email(request.getEmail())
                    .build();

            member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));


            memberRepository.save(member);
            return "register success ";

//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("sssss");
//
//            throw new Exception("wrong request");
//
//        }


    }

    public SignResponse getMember(String account) throws Exception {
        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("cannot find account"));
        return new SignResponse(member);
    }

    public List<alluserresponse> getmembers() throws Exception {
        return memberRepository.findAll().stream()
                .map(member -> alluserresponse.from(member))
                .collect(Collectors.toList());
    }

    public String deleteaccount(String account) throws Exception {

        Member member = memberRepository.findByAccount(account)
                .orElseThrow(() -> new Exception("can't find account"));
        memberRepository.delete(member);
        return "deleted account " + member.getAccount();


    }

    public String modifypwd(String account, String password) throws Exception {
        Member member = memberRepository.findByAccount(account).
                orElseThrow(() -> new Exception("can't find account"));

        member.setPassword(passwordEncoder.encode(password));

        return "password changed to " + password;

    }

}
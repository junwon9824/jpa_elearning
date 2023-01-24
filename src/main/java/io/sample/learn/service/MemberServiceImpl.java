//package io.sample.learn.service;
//import org.springframework.transaction.annotation.Transactional;
//import io.sample.learn.dto.MemberSignUpRequestDto;
//import io.sample.learn.entity.*;
//import io.sample.learn.repository.*;
// import lombok.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//@Service
//public class MemberServiceImpl implements MemberService {
//
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Transactional
//    @Override
//    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception {
//
//        if (memberRepository.findByEmail(requestDto.getEmail()).isPresent()){
//            throw new Exception("이미 존재하는 이메일입니다.");
//        }
//
//        if (!requestDto.getPassword().equals(requestDto.getCheckedPassword())){
//            throw new Exception("비밀번호가 일치하지 않습니다.");
//        }
//
//        Member member = memberRepository.save(requestDto.toEntity());
//        member.encodePassword(passwordEncoder);
//
//        member.addUserAuthority();
//        return member.getId();
//    }
//}
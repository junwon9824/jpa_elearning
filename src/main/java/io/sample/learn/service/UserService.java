package io.sample.learn.service;

//import io.sample.learn.dto.userdto;

//import io.sample.learn.entity.Role;
import io.sample.learn.entity.BuyFiles;
import io.sample.learn.entity.Member;
 //import io.sample.learn.repository.RoleRepository;
import io.sample.learn.repository.MemberRepository;
 import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional

@RequiredArgsConstructor
public class UserService {
   private final MemberRepository memberRepository;

    public String showboughtfiles ( String email)
    {
        Member member=memberRepository.findByemail(email);

        List<BuyFiles> list= member.getFiles();

        String str = "";

        for (int i=0;i<list.size();i++)
        {
            str+=list.get(i).getFile().getText().toString()+'\n';


        }

        return str;
    }


}
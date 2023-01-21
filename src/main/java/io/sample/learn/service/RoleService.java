package io.sample.learn.service;

import io.sample.learn.entity.Role;
import io.sample.learn.entity.User;
import io.sample.learn.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService   {
    private final RoleRepository roleRepository;

    @Transactional
     public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(IllegalAccessError::new);
    }



}

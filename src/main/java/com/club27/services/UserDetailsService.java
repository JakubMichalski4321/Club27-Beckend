package com.club27.services;

import com.club27.domain.UserAccount;
import com.club27.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserAccount> users = userRepository.findByName(username);
        if(users.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find user with these credentials");
        }
        UserAccount user = users.get(0);

        return new org.springframework.security.core.userdetails.User
                (user.getName(), bCryptPasswordEncoder.encode(user.getPass()), new ArrayList<>());
    }
}

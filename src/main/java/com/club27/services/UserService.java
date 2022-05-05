package com.club27.services;

import com.club27.domain.UserAccount;
import com.club27.exception.UserExistsException;
import com.club27.repositories.UserRepository;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount registerNewUser(UserDto userDto) throws UserExistsException {
        if(userNameExists(userDto.name())){
            throw new UserExistsException("Istnieje już użytkownik o nazwie " + userDto.name());
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setName(userDto.name());
        userAccount.setPass(passwordEncoder.encode(userDto.pass()));

        return userRepository.save(userAccount);
    }

    public Boolean userNameExists(String name){
        return !userRepository.findByName(name).isEmpty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //For testing always return user "someUser" with password "somePass"

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User
                        ("someUser", bCryptPasswordEncoder.encode("somePass"), new ArrayList<>());

        if(user == null) {
            throw new UsernameNotFoundException("Cannot find user with these credentials");
        }
        return user;
    }
}

package com.club27.services;

import com.club27.domain.UserAccount;
import com.club27.exception.UserExistsException;
import com.club27.repositories.UserAccountRepository;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserAccountRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount registerNewUser(UserDto userDto) throws UserExistsException {
        if (userNameExists(userDto.username())) {
            throw new UserExistsException("Istnieje już użytkownik o nazwie " + userDto.username());
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setName(userDto.username());
        userAccount.setPass(bCryptPasswordEncoder.encode(userDto.password()));

        return userRepository.save(userAccount);
    }

    public Boolean userNameExists(String name) {
        return !userRepository.findByName(name).isEmpty();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserAccount> users = userRepository.findByName(s);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find user with these credentials");
        }
        UserAccount user = users.get(0);
        System.out.println(user.getPass());
        return new org.springframework.security.core.userdetails.User
                (user.getName(), user.getPass(), new ArrayList<>());
    }
}

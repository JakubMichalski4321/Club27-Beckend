package com.club27.services;

import com.club27.domain.UserAccount;
import com.club27.exception.UserExistsException;
import com.club27.repositories.UserRepository;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

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

}

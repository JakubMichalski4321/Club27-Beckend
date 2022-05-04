package com.club27.services;

import com.club27.domain.User;
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

    public User registerNewUser(UserDto userDto) throws UserExistsException {
        if(userNameExists(userDto.name())){
            throw new UserExistsException("Istnieje już użytkownik o nazwie " + userDto.name());
        }

        User user = new User();
        user.setName(userDto.name());
        user.setPass(passwordEncoder.encode(userDto.pass()));

        return userRepository.save(user);
    }

    public Boolean userNameExists(String name){
        return !userRepository.findByName(name).isEmpty();
    }

}

package com.club27.services;

import com.club27.domain.UserAccount;
import com.club27.exception.UserExistsException;
import com.club27.repositories.UserRepository;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount registerNewUser(UserDto userDto) throws UserExistsException {
        if(userNameExists(userDto.username())){
            throw new UserExistsException("Istnieje już użytkownik o nazwie " + userDto.username());
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setName(userDto.username());
        userAccount.setPass(bCryptPasswordEncoder.encode(userDto.password()));

        return userRepository.save(userAccount);
    }

    public Boolean userNameExists(String name){
        return !userRepository.findByName(name).isEmpty();
    }

}

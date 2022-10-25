package com.club27.web.controllers;

import com.club27.services.UserService;
import com.club27.utilities.JwtUtil;
import com.club27.web.dto.AuthenticationResponse;
import com.club27.web.dto.LoginDto;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserDto userDto) {
        log.debug("register new user " + userDto.username());
        userService.registerNewUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user-exists/{userName}")
    public ResponseEntity<Boolean> userExists(@PathVariable("userName") String name) {
        var userExists = userService.userNameExists(name);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto loginDto) throws Exception {
        log.info("Login attempt for user: " + loginDto.username());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password())
            );
        } catch (BadCredentialsException badCredentialsException) {
            log.warn("Login attempt failed for user: " + loginDto.username());
            throw new Exception("Incorrect credentials", badCredentialsException);
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginDto.username());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        log.info("Login attempt successful for user: " + loginDto.username());
        log.info("JWT: " + jwt);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

}

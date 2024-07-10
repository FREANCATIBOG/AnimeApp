package com.Animefacts.co.AnimeApp.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.DTO.LoginRequest;
import com.Animefacts.co.AnimeApp.DTO.RegistrationRequest;
import com.Animefacts.co.AnimeApp.Model.Role;
import com.Animefacts.co.AnimeApp.Model.UserAuth;
import com.Animefacts.co.AnimeApp.Repository.RoleRepository;
import com.Animefacts.co.AnimeApp.Repository.UserAuthRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder PasswordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        //check if username exist in db
        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is Already Taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An Account is Already registered in this Email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            PasswordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);

    }

    @PostMapping("/register/User")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){

        //check if username exist in db
        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is Already Taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An Account is Already registered in this Email", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            PasswordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsernameOrEmail(),
                    loginRequest.getPassword()
                )
            );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User logged in Succesfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        
    }

}

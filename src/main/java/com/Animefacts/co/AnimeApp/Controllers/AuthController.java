package com.Animefacts.co.AnimeApp.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    AuthenticationManager uAuthenticationManager;


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

}

package com.registration.application.controller;


import com.registration.application.beans.LoginRequest;
import com.registration.application.beans.ResponseBean;
import com.registration.application.beans.UserInfo;
import com.registration.application.beans.UserRegistrationRequest;
import com.registration.application.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(path = "/v1/registrationservice")
public class RegistrationServiceController {


    @Autowired
    UserDetailsService userDetailsService;

    @CrossOrigin
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        ResponseBean  responseBean = userDetailsService.registerUser(userRegistrationRequest);
        return new ResponseEntity<>(responseBean, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(path = "/userinfo/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserInfo(@PathVariable(value = "email") String email){
        UserInfo userInfo = userDetailsService.getUserInfo(email);
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        ResponseBean responseBean= userDetailsService.login(loginRequest);
        return new ResponseEntity<>(responseBean,HttpStatus.ACCEPTED);
    }
}

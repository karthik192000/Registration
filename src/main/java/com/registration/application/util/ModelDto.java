package com.registration.application.util;

import com.registration.application.beans.UserInfo;
import com.registration.application.beans.UserRegistrationRequest;
import com.registration.application.model.UserDetails;

public class ModelDto {



    public static UserDetails toModel(UserRegistrationRequest userRegistrationRequest){
        String userName = userRegistrationRequest.getUserName();
        String name = userRegistrationRequest.getName();
        String email = userRegistrationRequest.getEmail();
        String password = RegistrationServiveUtil.stringToAscii(userRegistrationRequest.getPassword());
        Long phoneNumber = userRegistrationRequest.getPhoneNumber();
        String gender = userRegistrationRequest.getGender();
        UserDetails userDetails = new UserDetails(name,email,userName,phoneNumber,password,gender);
        return userDetails;
    }

    public static UserInfo toDto(UserDetails userDetails){
        String name = userDetails.getName();
        String email = userDetails.getEmail();
        Long phoneNumber = userDetails.getPhonenumber();
        UserInfo userInfo = new UserInfo(name,email,phoneNumber);
        return userInfo;
    }
}

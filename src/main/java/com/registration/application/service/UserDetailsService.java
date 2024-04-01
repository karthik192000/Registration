package com.registration.application.service;

import com.registration.application.beans.LoginRequest;
import com.registration.application.beans.ResponseBean;
import com.registration.application.beans.UserInfo;
import com.registration.application.beans.UserRegistrationRequest;

public interface UserDetailsService {



    public ResponseBean registerUser(UserRegistrationRequest userRegistrationRequest);


    public UserInfo getUserInfo(String userName);

    public ResponseBean login(LoginRequest loginRequest);
}

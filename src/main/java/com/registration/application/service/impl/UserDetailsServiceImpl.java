package com.registration.application.service.impl;

import com.registration.application.beans.LoginRequest;
import com.registration.application.beans.ResponseBean;
import com.registration.application.beans.UserInfo;
import com.registration.application.beans.UserRegistrationRequest;
import com.registration.application.helper.RegistrationServiceConstants;
import com.registration.application.model.UserDetails;
import com.registration.application.repository.UserDetailsRepository;
import com.registration.application.service.UserDetailsService;
import com.registration.application.util.ModelDto;
import com.registration.application.util.RegistrationServiceException;
import com.registration.application.util.RegistrationServiveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public ResponseBean registerUser(UserRegistrationRequest userRegistrationRequest) {
        ResponseBean responseBean =  null;
        try {
            if (userRegistrationRequest != null) {
                UserDetails userDetails = ModelDto.toModel(userRegistrationRequest);
                userDetailsRepository.save(userDetails);
                String status = RegistrationServiceConstants.STATUS_SUCCESS;
                responseBean = new ResponseBean(status,null,201);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RegistrationServiceException("Exception occurred during registering user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseBean;

    }


    @Override
    public UserInfo getUserInfo(String email) {
        UserInfo userInfo = null;
        try{
            UserDetails userDetails = userDetailsRepository.findByEmail(email);
            if(userDetails != null){
                userInfo = ModelDto.toDto(userDetails);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RegistrationServiceException("Exception occurred during fetching user details",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  userInfo;
    }


    @Override
    public ResponseBean login(LoginRequest loginRequest) {
        ResponseBean responseBean = null;
        try{
            String email = loginRequest.getEmail();
            UserDetails userDetails = userDetailsRepository.findByEmail(email);
            if(userDetails != null){
                String savedPassword = userDetails.getPasswrd();
                String requestPassword =  RegistrationServiveUtil.stringToAscii(loginRequest.getPassword());
                if(!requestPassword.equals(savedPassword)){
                    throw new RegistrationServiceException("Authentication Failed",HttpStatus.UNAUTHORIZED);
                }
                responseBean = new ResponseBean(RegistrationServiceConstants.STATUS_SUCCESS,null,202);

            }
        }
        catch (RegistrationServiceException ex){
            throw ex;
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new RegistrationServiceException("Exception occurred during login",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseBean;
    }
}

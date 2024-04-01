package com.registration.application.repository;

import com.registration.application.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {


    UserDetails findByUsername(String username);

    UserDetails findByEmail(String email);
}

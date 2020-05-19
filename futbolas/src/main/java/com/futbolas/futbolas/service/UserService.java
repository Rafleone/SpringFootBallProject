package com.futbolas.futbolas.service;



import com.futbolas.futbolas.model.User;
import com.futbolas.futbolas.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

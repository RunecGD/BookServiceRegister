package com.modsen.bookServiceRegister.service;

import com.modsen.bookServiceRegister.configuration.SecurityConfig;
import com.modsen.bookServiceRegister.dto.UserDTO;
import com.modsen.bookServiceRegister.model.User;
import com.modsen.bookServiceRegister.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;

    public User register(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        String encodedPassword = securityConfig.passwordEncoder().encode(userDTO.password());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

}

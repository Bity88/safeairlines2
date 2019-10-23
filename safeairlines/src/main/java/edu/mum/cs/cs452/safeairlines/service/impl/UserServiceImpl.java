package edu.mum.cs.cs452.safeairlines.service.impl;

import edu.mum.cs.cs452.safeairlines.model.User;
import edu.mum.cs.cs452.safeairlines.repository.UserRepository;
import edu.mum.cs.cs452.safeairlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return   userRepository.save(user);

    }

    public User checkExistingUser(String email) {
        return userRepository.getByEmail(email);
    }
}

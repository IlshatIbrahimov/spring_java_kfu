package com.spacex.services;

import com.spacex.forms.SignUpForm;
import com.spacex.models.User;
import com.spacex.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .passwordHash(passwordEncoder.encode(form.getPassword()))
                .build();
        usersRepository.save(user);
    }
}

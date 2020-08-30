package com.devdro.expensetracker.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devdro.expensetracker.domain.User;
import com.devdro.expensetracker.exceptions.EtAuthExpcetion;
import com.devdro.expensetracker.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthExpcetion {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthExpcetion {
        email = formatEmail(email);
        validateEmailPattern(email);
        Integer userId = createUser(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }

    private Integer createUser(String firstName, String lastName, String email, String password) {
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthExpcetion("Email already in use");
        return userRepository.create(firstName, lastName, email, password);
    }

    private void validateEmailPattern(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (!pattern.matcher(email).matches())
            throw new EtAuthExpcetion("Invalid email format");
    }

    private String formatEmail(String email) {
        if (email != null)
            email = email.toLowerCase();
        return email;
    }
}

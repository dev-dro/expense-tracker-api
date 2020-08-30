package com.devdro.expensetracker.services;

import com.devdro.expensetracker.domain.User;
import com.devdro.expensetracker.exceptions.EtAuthExpcetion;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthExpcetion;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthExpcetion;
}

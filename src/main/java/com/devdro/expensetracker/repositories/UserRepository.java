package com.devdro.expensetracker.repositories;

import com.devdro.expensetracker.domain.User;
import com.devdro.expensetracker.exceptions.EtAuthExpcetion;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws EtAuthExpcetion;
    User findByEmailAndPassword(String email, String password) throws EtAuthExpcetion;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
}

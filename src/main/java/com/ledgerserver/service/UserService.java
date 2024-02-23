/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/20
 */
package com.ledgerserver.service;

import com.ledgerserver.entity.User;
import com.ledgerserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }
}

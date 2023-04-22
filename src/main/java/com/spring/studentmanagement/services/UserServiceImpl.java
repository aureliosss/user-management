package com.spring.studentmanagement.services;

import com.spring.studentmanagement.exceptions.UserNotFoundExceptions;
import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created at 20.04.2023 by Dan.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public AppUser getUserById(Long userId) throws UserNotFoundExceptions {
        log.info("Trying to getUserById with param: userId = {}", userId);

        return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundExceptions("User not found!"));

    }
}


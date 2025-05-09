package me.dio.Service.impl;

import me.dio.Service.UserService;
import me.dio.domain.model.User;
import me.dio.domain.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            System.out.println("Hola");
            throw new IllegalArgumentException("This User Id Already exists");
        }
        return userRepository.save(userToCreate);
    }
}

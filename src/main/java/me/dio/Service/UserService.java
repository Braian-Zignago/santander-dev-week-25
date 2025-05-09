package me.dio.Service;

import me.dio.domain.model.User;

public interface UserService {
    User findById(long id);

    User create(User userToCreate);

}

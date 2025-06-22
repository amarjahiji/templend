package io.templend.service;

import io.templend.model.user.User;

import java.util.List;

public interface UserService {
    List<User> get() throws Exception;

    User getById(String id) throws Exception;

    User save(User user) throws Exception;

    String delete(String id) throws Exception;

    String login (User user) throws Exception;
}

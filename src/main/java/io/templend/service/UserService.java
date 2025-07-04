package io.templend.service;

import io.templend.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> get() throws Exception;

    User getById(String id) throws Exception;

    User save(User user) throws Exception;

    String delete(String id) throws Exception;

    String login (User user) throws Exception;

    List<User> getByIds(Set<String> ids) throws Exception;
}

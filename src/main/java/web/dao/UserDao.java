package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    User updateUser(User user);

    User getUserById(int id);

    void removeUserById(int id);

    void addUser(User user);

    List<User> listUsers(Integer count);
}

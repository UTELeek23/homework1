package dao.Interface;

import Models.Users;

import java.util.List;

public interface IUser {
    void addUser(Users user);

    Users getUser(String username, String password);

    void updateUser(Users user);

    void deleteUser(String username);
}

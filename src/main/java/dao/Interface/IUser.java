package dao.Interface;

import Models.Users;

import java.util.List;

public interface IUser {
    void addUser(Users user);

    Users getUser(String username, String password);

    Users updateUser(Users user);
//    void updatePassword(String oldPassword, String newPassword);
    void deleteUser(String username);
    Users getUserByUsername(String username);
}

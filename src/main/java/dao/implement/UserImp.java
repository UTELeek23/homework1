package dao.implement;

import Models.Users;
import dao.Interface.IUser;
import hisc.com.homework1.ConnectDB;

public class UserImp implements IUser {
    protected ConnectDB connectDB;
    @Override
    public void addUser(Users user) {

    }

    @Override
    public Users getUser(String username) {
        return null;
    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public void deleteUser(String username) {

    }
}

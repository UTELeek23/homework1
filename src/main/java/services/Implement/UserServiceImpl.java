package services.Implement;

import Models.Users;
import dao.implement.UserImp;
import services.Interface.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String username, String password) {
        UserImp userImp = new UserImp();
        userImp.getUser(username, password);
        return userImp.getUser(username, password) != null;
    }
}

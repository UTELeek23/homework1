package services.Implement;

import Models.Users;
import dao.implement.UserImp;
import services.Interface.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public Users login(String username, String password) {
        UserImp userImp = new UserImp();
        Users user = new Users();
        user = userImp.getUser(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }
}

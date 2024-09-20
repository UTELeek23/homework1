package services.Implement;

import Models.Users;
import dao.implement.UserImp;
import services.Interface.UserService;

import javax.lang.model.element.NestingKind;

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

    @Override
    public Users validateForgotPassword(String username, String answer, int QuestID) {
        UserImp userImp = new UserImp();
        Users user = new Users();
        user = userImp.getUserByUsername(username);
        if (user != null) {
            if(QuestID == user.getQuestID() && answer.equals(user.getAnswer())) {
                Users res =  new Users();
                res = userImp.updateUser(user);
                return res;
            }
        }
        return null;
    }
    public static void main( String[] args ) {
        UserServiceImpl userService = new UserServiceImpl();
        Users user = new Users();
        user = userService.validateForgotPassword("Duke", "HCM", 1);
        if (user != null) {
            System.out.println(user.getPassword());
        }
        else {
            System.out.println("failed");
        }
    }
}

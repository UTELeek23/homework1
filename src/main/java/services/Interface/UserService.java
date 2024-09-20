package services.Interface;

import Models.Users;

public interface UserService {
    Users login(String username, String password);
    Users validateForgotPassword(String username, String answer, int QuestID);
}

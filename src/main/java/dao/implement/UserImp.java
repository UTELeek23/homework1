package dao.implement;

import Models.Users;
import dao.Interface.IUser;
import hisc.com.homework1.ConnectDB;
import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImp implements IUser {
    protected ConnectDB connectDB;
    private static final String INSERT_USER_SQL = "INSERT INTO users (FullName, Username, Password, Email, QuestID, Answer, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_USER_SQL = "SELECT * FROM users WHERE Username = ? AND Password = ?";
    private static final String FIND_USER_Username = "SELECT * FROM users WHERE Username = ?";
    private static final String Update_User_Password = "UPDATE users SET Password = ? WHERE Username = ?";
    @Override
    public void addUser(Users user) {
        try{
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getQuestID());
            preparedStatement.setString(6, user.getAnswer());
            preparedStatement.setInt(7, user.getRoleID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connectDB.getConnection().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Users getUser(String username, String password) {
        try {
            Connection con = connectDB.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(FIND_USER_SQL);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Users user = new Users();
                user.setFullName(resultSet.getString("FullName"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));
                user.setEmail(resultSet.getString("Email"));
                user.setQuestID(resultSet.getInt("QuestID"));
                user.setAnswer(resultSet.getString("Answer"));
                user.setRoleID(resultSet.getInt("RoleID"));
                return user;
            }
            preparedStatement.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users updateUser(Users user) {
        String default_password = "HALOSX123";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(Update_User_Password);
            preparedStatement.setString(1, default_password);
            preparedStatement.setString(2, user.getUsername());
            Users res = new Users();
            // Use executeUpdate() for updating database records
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0 && user != null) {
                res = getUser(user.getUsername(), "HALOSX123");
                System.out.println("User password updated successfully.");
                preparedStatement.close();
                return res;
            } else {
                System.out.println("No user found with the given username.");
                preparedStatement.close();
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deleteUser(String username) {

    }

    @Override
    public Users getUserByUsername(String username) {
        try{
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND_USER_Username);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Users user = new Users();
                user.setFullName(resultSet.getString("FullName"));
                user.setUsername(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));
                user.setEmail(resultSet.getString("Email"));
                user.setQuestID(resultSet.getInt("QuestID"));
                user.setAnswer(resultSet.getString("Answer"));
                user.setRoleID(resultSet.getInt("RoleID"));
                return user;
            }
            preparedStatement.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main (String[] args) {
        UserImp userImp = new UserImp();
        Users user = new Users();
        String username = "Duke";
        int QuestID = 1;
        String answer = "HCM";
        user = userImp.getUser(username, "Hallo123");
        if (user != null) {
            System.out.println("User found with the given username.");
        }
        else {
            System.out.println("No user found with the given username.");
        }
        userImp.updateUser(user);
    }
}

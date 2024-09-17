package dao.implement;

import Models.Users;
import dao.Interface.IUser;
import hisc.com.homework1.ConnectDB;
import java.io.File;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserImp implements IUser {
    protected ConnectDB connectDB;
    private static final String INSERT_USER_SQL = "INSERT INTO users (FullName, Username, Password, Email, QuestID, Answer, RoleID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_USER_SQL = "SELECT * FROM users WHERE Username = ? AND Password = ?";
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
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND_USER_SQL);
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public void deleteUser(String username) {

    }
    public static void main (String[] args) {
        String filePath = "src/main/webapp/static/templates/login.jsp";

        // Tạo đối tượng File
        File file = new File(filePath);

        // Kiểm tra tệp có tồn tại không
        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
    }
}

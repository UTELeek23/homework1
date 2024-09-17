package Models;


import java.io.Serializable;
@SuppressWarnings("serial")
public class Users implements Serializable {
    private int ID;
    private String FullName;
    private String Username;
    private String Password;
    private String Email;
    private int QuestID;
    private String Answer;
    private int RoleID;
    public Users() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getQuestID() {
        return QuestID;
    }

    public void setQuestID(int questID) {
        QuestID = questID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

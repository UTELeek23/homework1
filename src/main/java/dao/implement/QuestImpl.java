package dao.implement;

import Models.Questions;
import dao.Interface.IQuest;
import hisc.com.homework1.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuestImpl implements IQuest {
    protected ConnectDB connectDB;
    String query = "SELECT * FROM questions";
    @Override
    public List<Questions> getQuestions() {
       try {
           connectDB = new ConnectDB();
           PreparedStatement ps = connectDB.getConnection().prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           List<Questions> questions = new ArrayList<Questions>();
           while (rs.next()) {
               Questions q = new Questions();
               q.setID(rs.getInt("QuestID"));
               q.setContent(rs.getString("Content"));
               questions.add(q);
           }
           questions.sort(Comparator.comparing(Questions::getID));
           ps.close();
           return questions;
       }
       catch (Exception e) {
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public int findID(String question) {
        try {
            connectDB = new ConnectDB();
            String q = "SELECT * FROM questions WHERE Content = ?";
            PreparedStatement ps = connectDB.getConnection().prepareStatement(q);
            ps.setString(1, question);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("QuestID");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main (String[] args) {
        IQuest quest = new QuestImpl();
        List<Questions> questions = quest.getQuestions();
        for (Questions q : questions) {
            System.out.println(q);
        }
        System.out.println(quest.findID("Món ăn yêu thích nhất ?"));
    }
}

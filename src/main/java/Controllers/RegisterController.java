package Controllers;


import Models.Questions;
import Models.Users;
import dao.Interface.IQuest;
import dao.implement.QuestImpl;
import dao.implement.UserImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/register")
public class RegisterController extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        QuestImpl quest = new QuestImpl();
        List<Questions> questions = quest.getQuestions();
        req.setAttribute("questions", questions);
        String alert = "";
        req.setAttribute("alert", alert);
        req.getRequestDispatcher("/static/templates/register.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Users user = new Users();
        UserImp userImp = new UserImp();
        try{
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            int question = Integer.parseInt(req.getParameter("quest"));
            String answer = req.getParameter("answer");
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            user.setUsername(username);
            user.setPassword(password);
            user.setFullName(fullName);
            user.setEmail(email);
            QuestImpl quest = new QuestImpl();
//            int QuestID = quest.findID(question);
            user.setQuestID(question);
            user.setAnswer(answer);
            user.setRoleID(3);
            if(user != null){
                userImp.addUser(user);
                String alert = "Registered Successfully";
                req.setAttribute("alert", alert);
                resp.sendRedirect(req.getContextPath() + "/Login");
            }
            else{
                String alert = "Something went wrong";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("/static/templates/register.jsp").forward(req,resp);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

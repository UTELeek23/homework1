package Controllers;

import Models.Questions;
import Models.Users;
import dao.implement.QuestImpl;
import dao.implement.UserImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.Implement.UserServiceImpl;
import services.Interface.UserService;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/forget")
public class ForgetPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        QuestImpl quest = new QuestImpl();
        List<Questions> questions = quest.getQuestions();
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("static/templates/forgetpass.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        UserService userService = new UserServiceImpl();
        try{
            String username = req.getParameter("username");
            int question = Integer.parseInt(req.getParameter("quest"));
            String answer = req.getParameter("answer");
            Users user = new Users();
            user = userService.validateForgotPassword(username,answer,question);
            if(user != null){
                String notice = "your password has been reset!" + user.getPassword();
                req.getSession().setAttribute("notice", notice);
                resp.sendRedirect(req.getContextPath() + "/forget");
;            }
            else{
                String alert = "Your password has not been reset!";
                req.getSession().setAttribute("alert", alert);
                resp.sendRedirect(req.getContextPath() + "/forget");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

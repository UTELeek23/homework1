package Controllers;

import Models.Users;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        HttpSession session = req.getSession();
        String basePath = System.getenv("BASE_PATH");  // Get base path from environment variable
        if (basePath == null) {
            basePath = req.getContextPath();  // Fallback if the environment variable is not set
        }
        if (session != null && session.getAttribute("user") != null) {
            Users u = (Users) session.getAttribute("user");
            req.setAttribute("user", u.getUsername());
            if (u.getRoleID() == 1){
                resp.sendRedirect(basePath+"/static/templates/homes/admin.jsp");
            }
            else if (u.getRoleID() == 2){
                resp.sendRedirect(basePath+"/static/templates/homes/editor.jsp");
            }
            else{
                resp.sendRedirect(basePath+"/static/templates/homes/user.jsp");
            }
        }
        else{
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}

package Controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the current session, if it exists
        HttpSession session = req.getSession(false); // 'false' means do not create a new session if it doesn't exist

        // If session exists, invalidate it to log out the user
        if (session != null) {
            session.invalidate();
        }

        // Redirect the user to the login page or homepage after logging out
        resp.sendRedirect(req.getContextPath() + "/Login"); // Change "/login" to your login page or any other page
    }
}

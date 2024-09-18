package Controllers;


import Models.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import services.Implement.UserServiceImpl;

import java.io.IOException;
import java.lang.annotation.Documented;

@SuppressWarnings("serial")
@WebServlet(name="Login", value = "/Login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
           resp.sendRedirect(req.getContextPath()+ "/waiting");
           return;
        }
        //check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    session = req.getSession(true);
                    session.setAttribute("user", cookie.getValue());
                    resp.sendRedirect(req.getContextPath()+ "/waiting");
                    return;

                }
            }
        }
        req.getRequestDispatcher("static/templates/login.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        UserServiceImpl userService = new UserServiceImpl();
        Users user = userService.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            if ("on".equals(rememberMe)) { // Check if "Remember Me" is selected
                saveRememberMe(resp, user.getUsername());
            }

            resp.sendRedirect(req.getContextPath()+"/waiting");
        }
        else {
            String alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("static/templates/login.jsp").forward(req, resp);

        }
    }
    private void saveRememberMe(HttpServletResponse response, String username) {
    Cookie cookie = new Cookie("user", username);
    cookie.setMaxAge(30 * 60); // Set cookie expiration to 30 minutes (1800 seconds)
    cookie.setPath("/"); // Set the path to the root, so the cookie is available across the application
    response.addCookie(cookie);
    }
}

package ir.maktab.ticket.servlet;

import ir.maktab.ticket.domain.User;
import ir.maktab.ticket.util.ApplicationContext;
import ir.maktab.ticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            ApplicationContext.getUserService().login(username, password);
            User user = ApplicationContext.getUserService().getUserByUsername(username);
            SecurityContext.setCurrentUser(user);
            HttpSession session = req.getSession();
            session.setAttribute("current_user", user);
            if (user.getType().equals("Passenger")) {
                resp.sendRedirect(req.getContextPath() + "/jsp/user.jsp");
            } else if (user.getType().equals("Admin")) {
                resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
            }
        } catch (Exception e) {
            resp.sendError(400, e.getMessage());
        }
    }

}

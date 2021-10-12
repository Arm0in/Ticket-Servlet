package ir.maktab.ticket.servlet;

import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.util.ApplicationContext;
import ir.maktab.ticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBalanceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Double amountToAdd = Double.parseDouble(req.getParameter("amount"));
        out.println(amountToAdd);
        try {
            ApplicationContext.getPassengerService().addToBalance((Passenger) SecurityContext.getCurrentUser(), amountToAdd);
//            resp.sendRedirect(req.getContextPath() + "/jsp/user.jsp");

            out.println("success!");
        } catch (Exception e) {
            resp.sendError(500, e.getMessage());
        }
    }
}

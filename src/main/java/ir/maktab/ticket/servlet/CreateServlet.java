package ir.maktab.ticket.servlet;

import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Passenger passenger = new Passenger();
        passenger.setUsername(req.getParameter("username"));
        passenger.setPassword(req.getParameter("password"));
        passenger.setEmail(req.getParameter("email"));
        passenger.setFirstname(req.getParameter("firstname"));
        passenger.setLastname(req.getParameter("lastname"));
        passenger.setMobileNumber(req.getParameter("mobilenumber"));
        String birthDateStr = req.getParameter("birthdate");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        passenger.setBirthDate(LocalDate.parse(birthDateStr, dtf));
        passenger.setBalance(0d);
        try {
            ApplicationContext.getPassengerService().save(passenger);
            out.println("<p>User added successfully.</p>");
            resp.sendRedirect(req.getContextPath());
        } catch (Exception e) {
            resp.sendError(500, e.getMessage());
        }

    }
}

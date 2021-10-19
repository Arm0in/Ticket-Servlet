package ir.maktab.ticket.servlet;

import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Sale;
import ir.maktab.ticket.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class AddDiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double discount = Double.parseDouble(req.getParameter("discount"));
        Flight flight = ApplicationContext.getFlightService().findById(Long.parseLong(req.getParameter("flightId")));
        Sale sale = new Sale(discount, flight, LocalDateTime.now(), LocalDateTime.now());
        resp.sendRedirect(req.getContextPath() + "/jsp/admin.jsp");
        try {
            ApplicationContext.getSaleService().save(sale);
        } catch (Exception e) {
            resp.sendError(500, e.getMessage());
        }
    }
}

package ir.maktab.ticket.servlet;

import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.enumeration.SeatType;
import ir.maktab.ticket.util.ApplicationContext;
import ir.maktab.ticket.util.SecurityContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long flightId = Long.parseLong(req.getParameter("flight"));
        try {
            Flight chosenFlight = ApplicationContext.getFlightService().findById(flightId);
            System.out.println("CHosen flight: " + chosenFlight);
            ApplicationContext.getPurchaseService().purchase((Passenger) SecurityContext.getCurrentUser(),
                    chosenFlight,
                    SeatType.ECONOMY);
            PrintWriter out = resp.getWriter();
            out.println("success!");
        } catch (Exception e) {
            resp.sendError(400, e.getMessage());
        }
    }
}

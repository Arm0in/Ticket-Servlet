package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.Sale;
import ir.maktab.ticket.domain.Ticket;
import ir.maktab.ticket.domain.enumeration.SeatType;
import ir.maktab.ticket.service.FlightService;
import ir.maktab.ticket.service.PassengerService;
import ir.maktab.ticket.service.PurchaseService;
import ir.maktab.ticket.util.ApplicationContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PurchaseServiceImpl implements PurchaseService {
    private final PassengerService passengerService;
    private final FlightService flightService;

    public PurchaseServiceImpl(PassengerService passengerService, FlightService flightService) {
        this.passengerService = passengerService;
        this.flightService = flightService;
    }


    @Override
    public void purchase(Passenger passenger, Flight flight, SeatType seatType) {
        Sale sale = ApplicationContext.getSaleService().findFlightSale(flight);
        if (ChronoUnit.HOURS.between(LocalDateTime.now(), flight.getDepartureTime()) < 1) {
            sale.setDiscount(sale.getDiscount() + 0.5D);
            ApplicationContext.getSaleService().save(sale);
        }
        if (ApplicationContext.getTicketService().countPassengerTickets(passenger) >= 10) {
            sale.setDiscount(1D);
            ApplicationContext.getSaleService().save(sale);
        }
        Double discount = ApplicationContext.getSaleService().findFlightSale(flight).getDiscount();
        if (seatType.equals(SeatType.ECONOMY)) {
            if (flight.getEconomySeats() >= 1) {
                if (passenger.getBalance() >= flight.getEconomyCost() * (1 - discount)) {
                    passenger.setBalance(passenger.getBalance() - flight.getEconomyCost() * (1 - discount));
                    ApplicationContext.getPassengerService().save(passenger);
                    flight.setEconomySeats(flight.getEconomySeats() - 1);
                    ApplicationContext.getFlightService().save(flight);
                    Ticket ticket = new Ticket(SeatType.ECONOMY, flight.getEconomyCost(), flight, passenger);
                    ApplicationContext.getTicketService().save(ticket);
                }
            }
        } else if (seatType.equals(SeatType.BUSINESS)) {
            if (flight.getBusinessSeats() >= 1) {
                if (passenger.getBalance() >= flight.getBusinessCost() * (1 - discount)) {
                    passenger.setBalance(passenger.getBalance() - flight.getBusinessCost() * (1 - discount));
                    ApplicationContext.getPassengerService().save(passenger);
                    flight.setBusinessSeats(flight.getBusinessSeats() - 1);
                    ApplicationContext.getFlightService().save(flight);
                    Ticket ticket = new Ticket(SeatType.BUSINESS, flight.getBusinessCost(), flight, passenger);
                    ApplicationContext.getTicketService().save(ticket);
                }
            }
        }
    }
}
